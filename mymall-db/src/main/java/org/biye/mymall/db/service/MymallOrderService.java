package org.biye.mymall.db.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.biye.mymall.db.dao.MymallOrderMapper;
import org.biye.mymall.db.dao.OrderMapper;
import org.biye.mymall.db.domain.MymallOrder;
import org.biye.mymall.db.domain.MymallOrderExample;
import org.biye.mymall.db.domain.OrderVo;
import org.biye.mymall.db.util.OrderUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
public class MymallOrderService {
    @Resource
    private MymallOrderMapper mymallOrderMapper;
    @Resource
    private OrderMapper orderMapper;

    public int add(MymallOrder order) {
        order.setAddTime(LocalDateTime.now());
        order.setUpdateTime(LocalDateTime.now());
        return mymallOrderMapper.insertSelective(order);
    }

    public int count(Integer userId) {
        MymallOrderExample example = new MymallOrderExample();
        example.or().andUserIdEqualTo(userId).andDeletedEqualTo(false);
        return (int) mymallOrderMapper.countByExample(example);
    }

    public MymallOrder findById(Integer orderId) {
        return mymallOrderMapper.selectByPrimaryKey(orderId);
    }

    public MymallOrder findById(Integer userId, Integer orderId) {
        MymallOrderExample example = new MymallOrderExample();
        example.or().andIdEqualTo(orderId).andUserIdEqualTo(userId).andDeletedEqualTo(false);
        return mymallOrderMapper.selectOneByExample(example);
    }

    private String getRandomNum(Integer num) {
        String base = "0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < num; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

    public int countByOrderSn(Integer userId, String orderSn) {
        MymallOrderExample example = new MymallOrderExample();
        example.or().andUserIdEqualTo(userId).andOrderSnEqualTo(orderSn).andDeletedEqualTo(false);
        return (int) mymallOrderMapper.countByExample(example);
    }

    // TODO 这里应该产生一个唯一的订单，但是实际上这里仍然存在两个订单相同的可能性
    public String generateOrderSn(Integer userId) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyyMMdd");
        String now = df.format(LocalDate.now());
        String orderSn = now + getRandomNum(6);
        while (countByOrderSn(userId, orderSn) != 0) {
            orderSn = now + getRandomNum(6);
        }
        return orderSn;
    }

    public List<MymallOrder> queryByOrderStatus(Integer userId, List<Short> orderStatus, Integer page, Integer limit, String sort, String order) {
        MymallOrderExample example = new MymallOrderExample();
        example.setOrderByClause(MymallOrder.Column.addTime.desc());
        MymallOrderExample.Criteria criteria = example.or();
        criteria.andUserIdEqualTo(userId);
        if (orderStatus != null) {
            criteria.andOrderStatusIn(orderStatus);
        }
        criteria.andDeletedEqualTo(false);
        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, limit);
        return mymallOrderMapper.selectByExample(example);
    }

    public List<MymallOrder> querySelective(Integer userId, String orderSn, LocalDateTime start, LocalDateTime end, List<Short> orderStatusArray, Integer page, Integer limit, String sort, String order) {
        MymallOrderExample example = new MymallOrderExample();
        MymallOrderExample.Criteria criteria = example.createCriteria();

        if (userId != null) {
            criteria.andUserIdEqualTo(userId);
        }
        if (!StringUtils.isEmpty(orderSn)) {
            criteria.andOrderSnEqualTo(orderSn);
        }
        if(start != null){
            criteria.andAddTimeGreaterThanOrEqualTo(start);
        }
        if(end != null){
            criteria.andAddTimeLessThanOrEqualTo(end);
        }
        if (orderStatusArray != null && orderStatusArray.size() != 0) {
            criteria.andOrderStatusIn(orderStatusArray);
        }
        criteria.andDeletedEqualTo(false);

        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, limit);
        return mymallOrderMapper.selectByExample(example);
    }

    public int updateWithOptimisticLocker(MymallOrder order) {
        LocalDateTime preUpdateTime = order.getUpdateTime();
        order.setUpdateTime(LocalDateTime.now());
        return orderMapper.updateWithOptimisticLocker(preUpdateTime, order);
    }

    public int updateSelective(MymallOrder order) {
        return mymallOrderMapper.updateByPrimaryKeySelective(order);
    }


    public void deleteById(Integer id) {
        mymallOrderMapper.logicalDeleteByPrimaryKey(id);
    }

    public int count() {
        MymallOrderExample example = new MymallOrderExample();
        example.or().andDeletedEqualTo(false);
        return (int) mymallOrderMapper.countByExample(example);
    }

    public List<MymallOrder> queryUnpaid(int minutes) {
        MymallOrderExample example = new MymallOrderExample();
        example.or().andOrderStatusEqualTo(OrderUtil.STATUS_CREATE).andDeletedEqualTo(false);
        return mymallOrderMapper.selectByExample(example);
    }

    public List<MymallOrder> queryUnconfirm(int days) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime expired = now.minusDays(days);
        MymallOrderExample example = new MymallOrderExample();
        example.or().andOrderStatusEqualTo(OrderUtil.STATUS_SHIP).andShipTimeLessThan(expired).andDeletedEqualTo(false);
        return mymallOrderMapper.selectByExample(example);
    }

    public MymallOrder findBySn(String orderSn) {
        MymallOrderExample example = new MymallOrderExample();
        example.or().andOrderSnEqualTo(orderSn).andDeletedEqualTo(false);
        return mymallOrderMapper.selectOneByExample(example);
    }

    public Map<Object, Object> orderInfo(Integer userId) {
        MymallOrderExample example = new MymallOrderExample();
        example.or().andUserIdEqualTo(userId).andDeletedEqualTo(false);
        List<MymallOrder> orders = mymallOrderMapper.selectByExampleSelective(example, MymallOrder.Column.orderStatus, MymallOrder.Column.comments);

        int unpaid = 0;
        int unship = 0;
        int unrecv = 0;
        int uncomment = 0;
        for (MymallOrder order : orders) {
            if (OrderUtil.isCreateStatus(order)) {
                unpaid++;
            } else if (OrderUtil.isPayStatus(order)) {
                unship++;
            } else if (OrderUtil.isShipStatus(order)) {
                unrecv++;
            } else if (OrderUtil.isConfirmStatus(order) || OrderUtil.isAutoConfirmStatus(order)) {
                uncomment += order.getComments();
            } else {
                // do nothing
            }
        }

        Map<Object, Object> orderInfo = new HashMap<Object, Object>();
        orderInfo.put("unpaid", unpaid);
        orderInfo.put("unship", unship);
        orderInfo.put("unrecv", unrecv);
        orderInfo.put("uncomment", uncomment);
        return orderInfo;

    }

    public List<MymallOrder> queryComment(int days) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime expired = now.minusDays(days);
        MymallOrderExample example = new MymallOrderExample();
        example.or().andCommentsGreaterThan((short) 0).andConfirmTimeLessThan(expired).andDeletedEqualTo(false);
        return mymallOrderMapper.selectByExample(example);
    }

    public void updateAftersaleStatus(Integer orderId, Short statusReject) {
        MymallOrder order = new MymallOrder();
        order.setId(orderId);
        order.setAftersaleStatus(statusReject);
        order.setUpdateTime(LocalDateTime.now());
        mymallOrderMapper.updateByPrimaryKeySelective(order);
    }


    public Map<String, Object> queryVoSelective(String nickname, String consignee, String orderSn, LocalDateTime start, LocalDateTime end, List<Short> orderStatusArray, Integer page, Integer limit, String sort, String order) {
        List<String> querys = new ArrayList<>(4);
        if (!StringUtils.isEmpty(nickname)) {
            querys.add(" u.nickname like '%" + nickname + "%' ");
        }
        if (!StringUtils.isEmpty(consignee)) {
            querys.add(" o.consignee like '%" + consignee + "%' ");
        }
        if (!StringUtils.isEmpty(orderSn)) {
            querys.add(" o.order_sn = '" + orderSn + "' ");
        }
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        if (start != null) {
            querys.add(" o.add_time >= '" + df.format(start) + "' ");
        }
        if (end != null) {
            querys.add(" o.add_time < '" + df.format(end) + "' ");
        }
        if (orderStatusArray != null && orderStatusArray.size() > 0) {
            querys.add(" o.order_status in (" + StringUtils.collectionToDelimitedString(orderStatusArray, ",") + ") ");
        }
        querys.add(" o.deleted = 0 and og.deleted = 0 ");
        String query = StringUtils.collectionToDelimitedString(querys, "and");
        String orderByClause = null;
        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            orderByClause = "o." + sort + " " + order +", o.id desc ";
        }

        PageHelper.startPage(page, limit);
        Page<Map> list1 = (Page) orderMapper.getOrderIds(query, orderByClause);
        List<Integer> ids = new ArrayList<>();
        for (Map map : list1) {
            Integer id = (Integer) map.get("id");
            ids.add(id);
        }

        List<OrderVo> list2 = new ArrayList<>();
        if (!ids.isEmpty()) {
            querys.add(" o.id in (" + StringUtils.collectionToDelimitedString(ids, ",") + ") ");
            query = StringUtils.collectionToDelimitedString(querys, "and");
            list2 = orderMapper.getOrderList(query, orderByClause);
        }
        Map<String, Object> data = new HashMap<String, Object>(5);
        data.put("list", list2);
        data.put("total", list1.getTotal());
        data.put("page", list1.getPageNum());
        data.put("limit", list1.getPageSize());
        data.put("pages", list1.getPages());
        return data;
    }
}
