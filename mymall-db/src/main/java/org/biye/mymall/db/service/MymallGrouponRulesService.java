package org.biye.mymall.db.service;

import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.PageHelper;
import org.biye.mymall.db.dao.MymallGoodsMapper;
import org.biye.mymall.db.dao.MymallGrouponRulesMapper;
import org.biye.mymall.db.domain.MymallGoods;
import org.biye.mymall.db.domain.MymallGrouponRules;
import org.biye.mymall.db.domain.MymallGrouponRulesExample;
import org.biye.mymall.db.util.GrouponConstant;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MymallGrouponRulesService {
    @Resource
    private MymallGrouponRulesMapper mapper;
    @Resource
    private MymallGoodsMapper goodsMapper;
    private MymallGoods.Column[] goodsColumns = new MymallGoods.Column[]{MymallGoods.Column.id, MymallGoods.Column.name, MymallGoods.Column.brief, MymallGoods.Column.picUrl, MymallGoods.Column.counterPrice, MymallGoods.Column.retailPrice};

    public int createRules(MymallGrouponRules rules) {
        rules.setAddTime(LocalDateTime.now());
        rules.setUpdateTime(LocalDateTime.now());
        return mapper.insertSelective(rules);
    }

    /**
     * 根据ID查找对应团购项
     *
     * @param id
     * @return
     */
    public MymallGrouponRules findById(Integer id) {
        return mapper.selectByPrimaryKey(id);
    }

    /**
     * 查询某个商品关联的团购规则
     *
     * @param goodsId
     * @return
     */
    public List<MymallGrouponRules> queryByGoodsId(Integer goodsId) {
        MymallGrouponRulesExample example = new MymallGrouponRulesExample();
        example.or().andGoodsIdEqualTo(goodsId).andStatusEqualTo(GrouponConstant.RULE_STATUS_ON).andDeletedEqualTo(false);
        return mapper.selectByExample(example);
    }

    public int countByGoodsId(Integer goodsId) {
        MymallGrouponRulesExample example = new MymallGrouponRulesExample();
        example.or().andGoodsIdEqualTo(goodsId).andStatusEqualTo(GrouponConstant.RULE_STATUS_ON).andDeletedEqualTo(false);
        return (int)mapper.countByExample(example);
    }

    public List<MymallGrouponRules> queryByStatus(Short status) {
        MymallGrouponRulesExample example = new MymallGrouponRulesExample();
        example.or().andStatusEqualTo(status).andDeletedEqualTo(false);
        return mapper.selectByExample(example);
    }

    /**
     * 获取首页团购规则列表
     *
     * @param page
     * @param limit
     * @return
     */
    public List<MymallGrouponRules> queryList(Integer page, Integer limit) {
        return queryList(page, limit, "add_time", "desc");
    }

    public List<MymallGrouponRules> queryList(Integer page, Integer limit, String sort, String order) {
        MymallGrouponRulesExample example = new MymallGrouponRulesExample();
        example.or().andStatusEqualTo(GrouponConstant.RULE_STATUS_ON).andDeletedEqualTo(false);
        example.setOrderByClause(sort + " " + order);
        PageHelper.startPage(page, limit);
        return mapper.selectByExample(example);
    }

    /**
     * 判断某个团购规则是否已经过期
     *
     * @return
     */
    public boolean isExpired(MymallGrouponRules rules) {
        return (rules == null || rules.getExpireTime().isBefore(LocalDateTime.now()));
    }

    /**
     * 获取团购规则列表
     *
     * @param goodsId
     * @param page
     * @param size
     * @param sort
     * @param order
     * @return
     */
    public List<MymallGrouponRules> querySelective(String goodsId, Integer page, Integer size, String sort, String order) {
        MymallGrouponRulesExample example = new MymallGrouponRulesExample();
        example.setOrderByClause(sort + " " + order);

        MymallGrouponRulesExample.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(goodsId)) {
            criteria.andGoodsIdEqualTo(Integer.parseInt(goodsId));
        }
        criteria.andDeletedEqualTo(false);

        PageHelper.startPage(page, size);
        return mapper.selectByExample(example);
    }

    public void delete(Integer id) {
        mapper.logicalDeleteByPrimaryKey(id);
    }

    public int updateById(MymallGrouponRules grouponRules) {
        grouponRules.setUpdateTime(LocalDateTime.now());
        return mapper.updateByPrimaryKeySelective(grouponRules);
    }
}