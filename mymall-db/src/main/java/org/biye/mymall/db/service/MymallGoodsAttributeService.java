package org.biye.mymall.db.service;

import org.biye.mymall.db.dao.MymallGoodsAttributeMapper;
import org.biye.mymall.db.domain.MymallGoodsAttribute;
import org.biye.mymall.db.domain.MymallGoodsAttributeExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class MymallGoodsAttributeService {
    @Resource
    private MymallGoodsAttributeMapper goodsAttributeMapper;

    public List<MymallGoodsAttribute> queryByGid(Integer goodsId) {
        MymallGoodsAttributeExample example = new MymallGoodsAttributeExample();
        example.or().andGoodsIdEqualTo(goodsId).andDeletedEqualTo(false);
        return goodsAttributeMapper.selectByExample(example);
    }

    public void add(MymallGoodsAttribute goodsAttribute) {
        goodsAttribute.setAddTime(LocalDateTime.now());
        goodsAttribute.setUpdateTime(LocalDateTime.now());
        goodsAttributeMapper.insertSelective(goodsAttribute);
    }

    public MymallGoodsAttribute findById(Integer id) {
        return goodsAttributeMapper.selectByPrimaryKey(id);
    }

    public void deleteByGid(Integer gid) {
        MymallGoodsAttributeExample example = new MymallGoodsAttributeExample();
        example.or().andGoodsIdEqualTo(gid);
        goodsAttributeMapper.logicalDeleteByExample(example);
    }

    public void deleteById(Integer id) {
        goodsAttributeMapper.logicalDeleteByPrimaryKey(id);
    }

    public void updateById(MymallGoodsAttribute attribute) {
        attribute.setUpdateTime(LocalDateTime.now());
        goodsAttributeMapper.updateByPrimaryKeySelective(attribute);
    }
}
