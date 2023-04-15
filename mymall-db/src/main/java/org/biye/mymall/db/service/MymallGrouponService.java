package org.biye.mymall.db.service;

import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.PageHelper;
import org.biye.mymall.db.dao.MymallGrouponMapper;
import org.biye.mymall.db.domain.MymallGroupon;
import org.biye.mymall.db.domain.MymallGrouponExample;
import org.biye.mymall.db.util.GrouponConstant;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class MymallGrouponService {
    @Resource
    private MymallGrouponMapper mapper;

    /**
     * 获取用户发起的团购记录
     *
     * @param userId
     * @return
     */
    public List<MymallGroupon> queryMyGroupon(Integer userId) {
        MymallGrouponExample example = new MymallGrouponExample();
        example.or().andUserIdEqualTo(userId).andCreatorUserIdEqualTo(userId).andGrouponIdEqualTo(0).andStatusNotEqualTo(GrouponConstant.STATUS_NONE).andDeletedEqualTo(false);
        example.orderBy("add_time desc");
        return mapper.selectByExample(example);
    }

    /**
     * 获取用户参与的团购记录
     *
     * @param userId
     * @return
     */
    public List<MymallGroupon> queryMyJoinGroupon(Integer userId) {
        MymallGrouponExample example = new MymallGrouponExample();
        example.or().andUserIdEqualTo(userId).andGrouponIdNotEqualTo(0).andStatusNotEqualTo(GrouponConstant.STATUS_NONE).andDeletedEqualTo(false);
        example.orderBy("add_time desc");
        return mapper.selectByExample(example);
    }

    /**
     * 根据OrderId查询团购记录
     *
     * @param orderId
     * @return
     */
    public MymallGroupon queryByOrderId(Integer orderId) {
        MymallGrouponExample example = new MymallGrouponExample();
        example.or().andOrderIdEqualTo(orderId).andDeletedEqualTo(false);
        return mapper.selectOneByExample(example);
    }

    /**
     * 获取某个团购活动参与的记录
     *
     * @param id
     * @return
     */
    public List<MymallGroupon> queryJoinRecord(Integer id) {
        MymallGrouponExample example = new MymallGrouponExample();
        example.or().andGrouponIdEqualTo(id).andStatusNotEqualTo(GrouponConstant.STATUS_NONE).andDeletedEqualTo(false);
        example.orderBy("add_time desc");
        return mapper.selectByExample(example);
    }

    /**
     * 根据ID查询记录
     *
     * @param id
     * @return
     */
    public MymallGroupon queryById(Integer id) {
        MymallGrouponExample example = new MymallGrouponExample();
        example.or().andIdEqualTo(id).andDeletedEqualTo(false);
        return mapper.selectOneByExample(example);
    }

    /**
     * 根据ID查询记录
     *
     * @param userId
     * @param id
     * @return
     */
    public MymallGroupon queryById(Integer userId, Integer id) {
        MymallGrouponExample example = new MymallGrouponExample();
        example.or().andIdEqualTo(id).andUserIdEqualTo(userId).andDeletedEqualTo(false);
        return mapper.selectOneByExample(example);
    }

    /**
     * 返回某个发起的团购参与人数
     *
     * @param grouponId
     * @return
     */
    public int countGroupon(Integer grouponId) {
        MymallGrouponExample example = new MymallGrouponExample();
        example.or().andGrouponIdEqualTo(grouponId).andStatusNotEqualTo(GrouponConstant.STATUS_NONE).andDeletedEqualTo(false);
        return (int) mapper.countByExample(example);
    }

    public boolean hasJoin(Integer userId, Integer grouponId) {
        MymallGrouponExample example = new MymallGrouponExample();
        example.or().andUserIdEqualTo(userId).andGrouponIdEqualTo(grouponId).andStatusNotEqualTo(GrouponConstant.STATUS_NONE).andDeletedEqualTo(false);
        return  mapper.countByExample(example) != 0;
    }

    public int updateById(MymallGroupon groupon) {
        groupon.setUpdateTime(LocalDateTime.now());
        return mapper.updateByPrimaryKeySelective(groupon);
    }

    /**
     * 创建或参与一个团购
     *
     * @param groupon
     * @return
     */
    public int createGroupon(MymallGroupon groupon) {
        groupon.setAddTime(LocalDateTime.now());
        groupon.setUpdateTime(LocalDateTime.now());
        return mapper.insertSelective(groupon);
    }


    /**
     * 查询所有发起的团购记录
     *
     * @param rulesId
     * @param page
     * @param size
     * @param sort
     * @param order
     * @return
     */
    public List<MymallGroupon> querySelective(String rulesId, Integer page, Integer size, String sort, String order) {
        MymallGrouponExample example = new MymallGrouponExample();
        MymallGrouponExample.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(rulesId)) {
            criteria.andRulesIdEqualTo(Integer.parseInt(rulesId));
        }
        criteria.andDeletedEqualTo(false);
        criteria.andStatusNotEqualTo(GrouponConstant.STATUS_NONE);
        criteria.andGrouponIdEqualTo(0);

        PageHelper.startPage(page, size);
        return mapper.selectByExample(example);
    }

    public List<MymallGroupon> queryByRuleId(int grouponRuleId) {
        MymallGrouponExample example = new MymallGrouponExample();
        example.or().andRulesIdEqualTo(grouponRuleId).andDeletedEqualTo(false);
        return mapper.selectByExample(example);
    }
}
