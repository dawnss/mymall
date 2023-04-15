package org.biye.mymall.db.service;

import com.github.pagehelper.PageHelper;
import org.biye.mymall.db.dao.MymallBrandMapper;
import org.biye.mymall.db.domain.MymallBrand;
import org.biye.mymall.db.domain.MymallBrand.Column;
import org.biye.mymall.db.domain.MymallBrandExample;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class MymallBrandService {
    @Resource
    private MymallBrandMapper brandMapper;
    private Column[] columns = new Column[]{Column.id, Column.name, Column.desc, Column.picUrl, Column.floorPrice};

    public List<MymallBrand> query(Integer page, Integer limit, String sort, String order) {
        MymallBrandExample example = new MymallBrandExample();
        example.or().andDeletedEqualTo(false);
        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }
        PageHelper.startPage(page, limit);
        return brandMapper.selectByExampleSelective(example, columns);
    }

    public List<MymallBrand> query(Integer page, Integer limit) {
        return query(page, limit, null, null);
    }

    public MymallBrand findById(Integer id) {
        return brandMapper.selectByPrimaryKey(id);
    }

    public List<MymallBrand> querySelective(String id, String name, Integer page, Integer size, String sort, String order) {
        MymallBrandExample example = new MymallBrandExample();
        MymallBrandExample.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(id)) {
            criteria.andIdEqualTo(Integer.valueOf(id));
        }
        if (!StringUtils.isEmpty(name)) {
            criteria.andNameLike("%" + name + "%");
        }
        criteria.andDeletedEqualTo(false);

        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, size);
        return brandMapper.selectByExample(example);
    }

    public int updateById(MymallBrand brand) {
        brand.setUpdateTime(LocalDateTime.now());
        return brandMapper.updateByPrimaryKeySelective(brand);
    }

    public void deleteById(Integer id) {
        brandMapper.logicalDeleteByPrimaryKey(id);
    }

    public void add(MymallBrand brand) {
        brand.setAddTime(LocalDateTime.now());
        brand.setUpdateTime(LocalDateTime.now());
        brandMapper.insertSelective(brand);
    }

    public List<MymallBrand> all() {
        MymallBrandExample example = new MymallBrandExample();
        example.or().andDeletedEqualTo(false);
        return brandMapper.selectByExample(example);
    }
}
