package org.biye.mymall.db.service;

import com.github.pagehelper.PageHelper;
import org.biye.mymall.db.dao.MymallAftersaleMapper;
import org.biye.mymall.db.domain.*;
import org.biye.mymall.db.util.AftersaleConstant;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;

@Service
public class MymallAftersaleService {
    @Resource
    private MymallAftersaleMapper aftersaleMapper;

    public MymallAftersale findById(Integer id) {
        return aftersaleMapper.selectByPrimaryKey(id);
    }

    public MymallAftersale findById(Integer userId, Integer id) {
        MymallAftersaleExample example = new MymallAftersaleExample();
        example.or().andIdEqualTo(id).andUserIdEqualTo(userId).andDeletedEqualTo(false);
        return aftersaleMapper.selectOneByExample(example);
    }

    public List<MymallAftersale> queryList(Integer userId, Short status, Integer page, Integer limit, String sort, String order) {
        MymallAftersaleExample example = new MymallAftersaleExample();
        MymallAftersaleExample.Criteria criteria = example.or();
        criteria.andUserIdEqualTo(userId);
        if (status != null) {
            criteria.andStatusEqualTo(status);
        }
        criteria.andDeletedEqualTo(false);
        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }
        else{
            example.setOrderByClause(MymallAftersale.Column.addTime.desc());
        }

        PageHelper.startPage(page, limit);
        return aftersaleMapper.selectByExample(example);
    }

    public List<MymallAftersale> querySelective(Integer orderId, String aftersaleSn, Short status, Integer page, Integer limit, String sort, String order) {
        MymallAftersaleExample example = new MymallAftersaleExample();
        MymallAftersaleExample.Criteria criteria = example.or();
        if (orderId != null) {
            criteria.andOrderIdEqualTo(orderId);
        }
        if (!StringUtils.isEmpty(aftersaleSn)) {
            criteria.andAftersaleSnEqualTo(aftersaleSn);
        }
        if (status != null) {
            criteria.andStatusEqualTo(status);
        }
        criteria.andDeletedEqualTo(false);
        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }
        else{
            example.setOrderByClause(MymallAftersale.Column.addTime.desc());
        }

        PageHelper.startPage(page, limit);
        return aftersaleMapper.selectByExample(example);
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

    public int countByAftersaleSn(Integer userId, String aftersaleSn) {
        MymallAftersaleExample example = new MymallAftersaleExample();
        example.or().andUserIdEqualTo(userId).andAftersaleSnEqualTo(aftersaleSn).andDeletedEqualTo(false);
        return (int) aftersaleMapper.countByExample(example);
    }

    // TODO 这里应该产生一个唯一的编号，但是实际上这里仍然存在两个售后编号相同的可能性
    public String generateAftersaleSn(Integer userId) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyyMMdd");
        String now = df.format(LocalDate.now());
        String aftersaleSn = now + getRandomNum(6);
        while (countByAftersaleSn(userId, aftersaleSn) != 0) {
            aftersaleSn = now + getRandomNum(6);
        }
        return aftersaleSn;
    }

    public void add(MymallAftersale aftersale) {
        aftersale.setAddTime(LocalDateTime.now());
        aftersale.setUpdateTime(LocalDateTime.now());
        aftersaleMapper.insertSelective(aftersale);
    }

    public void deleteByIds(List<Integer> ids) {
        MymallAftersaleExample example = new MymallAftersaleExample();
        example.or().andIdIn(ids).andDeletedEqualTo(false);
        MymallAftersale aftersale = new MymallAftersale();
        aftersale.setUpdateTime(LocalDateTime.now());
        aftersale.setDeleted(true);
        aftersaleMapper.updateByExampleSelective(aftersale, example);
    }

    public void deleteById(Integer id) {
        aftersaleMapper.logicalDeleteByPrimaryKey(id);
    }

    public void deleteByOrderId(Integer userId, Integer orderId) {
        MymallAftersaleExample example = new MymallAftersaleExample();
        example.or().andOrderIdEqualTo(orderId).andUserIdEqualTo(userId).andDeletedEqualTo(false);
        MymallAftersale aftersale = new MymallAftersale();
        aftersale.setUpdateTime(LocalDateTime.now());
        aftersale.setDeleted(true);
        aftersaleMapper.updateByExampleSelective(aftersale, example);
    }

    public void updateById(MymallAftersale aftersale) {
        aftersale.setUpdateTime(LocalDateTime.now());
        aftersaleMapper.updateByPrimaryKeySelective(aftersale);
    }

    public MymallAftersale findByOrderId(Integer userId, Integer orderId) {
        MymallAftersaleExample example = new MymallAftersaleExample();
        example.or().andOrderIdEqualTo(orderId).andUserIdEqualTo(userId).andDeletedEqualTo(false);
        return aftersaleMapper.selectOneByExample(example);
    }
}
