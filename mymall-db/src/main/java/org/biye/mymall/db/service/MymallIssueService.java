package org.biye.mymall.db.service;

import com.github.pagehelper.PageHelper;
import org.biye.mymall.db.dao.MymallIssueMapper;
import org.biye.mymall.db.domain.MymallIssue;
import org.biye.mymall.db.domain.MymallIssueExample;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class MymallIssueService {
    @Resource
    private MymallIssueMapper issueMapper;

    public void deleteById(Integer id) {
        issueMapper.logicalDeleteByPrimaryKey(id);
    }

    public void add(MymallIssue issue) {
        issue.setAddTime(LocalDateTime.now());
        issue.setUpdateTime(LocalDateTime.now());
        issueMapper.insertSelective(issue);
    }

    public List<MymallIssue> querySelective(String question, Integer page, Integer limit, String sort, String order) {
        MymallIssueExample example = new MymallIssueExample();
        MymallIssueExample.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(question)) {
            criteria.andQuestionLike("%" + question + "%");
        }
        criteria.andDeletedEqualTo(false);

        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, limit);
        return issueMapper.selectByExample(example);
    }

    public int updateById(MymallIssue issue) {
        issue.setUpdateTime(LocalDateTime.now());
        return issueMapper.updateByPrimaryKeySelective(issue);
    }

    public MymallIssue findById(Integer id) {
        return issueMapper.selectByPrimaryKey(id);
    }
}
