package org.biye.mymall.db.service;

import com.github.pagehelper.PageHelper;
import org.biye.mymall.db.dao.MymallLogMapper;
import org.biye.mymall.db.domain.MymallAd;
import org.biye.mymall.db.domain.MymallLog;
import org.biye.mymall.db.domain.MymallLogExample;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class MymallLogService {
    @Resource
    private MymallLogMapper logMapper;

    public void deleteById(Integer id) {
        logMapper.logicalDeleteByPrimaryKey(id);
    }

    public void add(MymallLog log) {
        log.setAddTime(LocalDateTime.now());
        log.setUpdateTime(LocalDateTime.now());
        logMapper.insertSelective(log);
    }

    public List<MymallLog> querySelective(String name, Integer page, Integer size, String sort, String order) {
        MymallLogExample example = new MymallLogExample();
        MymallLogExample.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(name)) {
            criteria.andAdminLike("%" + name + "%");
        }
        criteria.andDeletedEqualTo(false);

        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, size);
        return logMapper.selectByExample(example);
    }
}
