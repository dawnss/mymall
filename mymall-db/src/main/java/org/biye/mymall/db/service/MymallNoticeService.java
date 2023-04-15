package org.biye.mymall.db.service;

import com.github.pagehelper.PageHelper;
import org.biye.mymall.db.dao.MymallNoticeMapper;
import org.biye.mymall.db.domain.MymallNotice;
import org.biye.mymall.db.domain.MymallNoticeAdmin;
import org.biye.mymall.db.domain.MymallNoticeAdminExample;
import org.biye.mymall.db.domain.MymallNoticeExample;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class MymallNoticeService {
    @Resource
    private MymallNoticeMapper noticeMapper;


    public List<MymallNotice> querySelective(String title, String content, Integer page, Integer limit, String sort, String order) {
        MymallNoticeExample example = new MymallNoticeExample();
        MymallNoticeExample.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(title)) {
            criteria.andTitleLike("%" + title + "%");
        }
        if (!StringUtils.isEmpty(content)) {
            criteria.andContentLike("%" + content + "%");
        }
        criteria.andDeletedEqualTo(false);

        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, limit);
        return noticeMapper.selectByExample(example);
    }

    public int updateById(MymallNotice notice) {
        notice.setUpdateTime(LocalDateTime.now());
        return noticeMapper.updateByPrimaryKeySelective(notice);
    }

    public void deleteById(Integer id) {
        noticeMapper.logicalDeleteByPrimaryKey(id);
    }

    public void add(MymallNotice notice) {
        notice.setAddTime(LocalDateTime.now());
        notice.setUpdateTime(LocalDateTime.now());
        noticeMapper.insertSelective(notice);
    }

    public MymallNotice findById(Integer id) {
        return noticeMapper.selectByPrimaryKey(id);
    }

    public void deleteByIds(List<Integer> ids) {
        MymallNoticeExample example = new MymallNoticeExample();
        example.or().andIdIn(ids).andDeletedEqualTo(false);
        MymallNotice notice = new MymallNotice();
        notice.setUpdateTime(LocalDateTime.now());
        notice.setDeleted(true);
        noticeMapper.updateByExampleSelective(notice, example);
    }
}
