package org.biye.mymall.db.service;

import com.github.pagehelper.PageHelper;
import org.biye.mymall.db.dao.MymallNoticeAdminMapper;
import org.biye.mymall.db.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class MymallNoticeAdminService {
    @Resource
    private MymallNoticeAdminMapper noticeAdminMapper;

    public List<MymallNoticeAdmin> querySelective(String title, String type, Integer adminId, Integer page, Integer limit, String sort, String order) {
        MymallNoticeAdminExample example = new MymallNoticeAdminExample();
        MymallNoticeAdminExample.Criteria criteria = example.createCriteria();

        if(!StringUtils.isEmpty(title)){
            criteria.andNoticeTitleLike("%" + title + "%");
        }

        if(type.equals("read")){
         criteria.andReadTimeIsNotNull();
        }
        else if(type.equals("unread")){
            criteria.andReadTimeIsNull();
        }
        criteria.andAdminIdEqualTo(adminId);
        criteria.andDeletedEqualTo(false);

        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, limit);
        return noticeAdminMapper.selectByExample(example);
    }

    public MymallNoticeAdmin find(Integer noticeId, Integer adminId) {
        MymallNoticeAdminExample example = new MymallNoticeAdminExample();
        example.or().andNoticeIdEqualTo(noticeId).andAdminIdEqualTo(adminId).andDeletedEqualTo(false);
        return noticeAdminMapper.selectOneByExample(example);
    }

    public void add(MymallNoticeAdmin noticeAdmin) {
        noticeAdmin.setAddTime(LocalDateTime.now());
        noticeAdmin.setUpdateTime(LocalDateTime.now());
        noticeAdminMapper.insertSelective(noticeAdmin);
    }

    public void update(MymallNoticeAdmin noticeAdmin) {
        noticeAdmin.setUpdateTime(LocalDateTime.now());
        noticeAdminMapper.updateByPrimaryKeySelective(noticeAdmin);
    }

    public void markReadByIds(List<Integer> ids, Integer adminId) {
        MymallNoticeAdminExample example = new MymallNoticeAdminExample();
        example.or().andIdIn(ids).andAdminIdEqualTo(adminId).andDeletedEqualTo(false);
        MymallNoticeAdmin noticeAdmin = new MymallNoticeAdmin();
        LocalDateTime now = LocalDateTime.now();
        noticeAdmin.setReadTime(now);
        noticeAdmin.setUpdateTime(now);
        noticeAdminMapper.updateByExampleSelective(noticeAdmin, example);
    }

    public void deleteById(Integer id, Integer adminId) {
        MymallNoticeAdminExample example = new MymallNoticeAdminExample();
        example.or().andIdEqualTo(id).andAdminIdEqualTo(adminId).andDeletedEqualTo(false);
        MymallNoticeAdmin noticeAdmin = new MymallNoticeAdmin();
        noticeAdmin.setUpdateTime(LocalDateTime.now());
        noticeAdmin.setDeleted(true);
        noticeAdminMapper.updateByExampleSelective(noticeAdmin, example);
    }

    public void deleteByIds(List<Integer> ids, Integer adminId) {
        MymallNoticeAdminExample example = new MymallNoticeAdminExample();
        example.or().andIdIn(ids).andAdminIdEqualTo(adminId).andDeletedEqualTo(false);
        MymallNoticeAdmin noticeAdmin = new MymallNoticeAdmin();
        noticeAdmin.setUpdateTime(LocalDateTime.now());
        noticeAdmin.setDeleted(true);
        noticeAdminMapper.updateByExampleSelective(noticeAdmin, example);
    }

    public int countUnread(Integer adminId) {
        MymallNoticeAdminExample example = new MymallNoticeAdminExample();
        example.or().andAdminIdEqualTo(adminId).andReadTimeIsNull().andDeletedEqualTo(false);
        return (int)noticeAdminMapper.countByExample(example);
    }

    public List<MymallNoticeAdmin> queryByNoticeId(Integer noticeId) {
        MymallNoticeAdminExample example = new MymallNoticeAdminExample();
        example.or().andNoticeIdEqualTo(noticeId).andDeletedEqualTo(false);
        return noticeAdminMapper.selectByExample(example);
    }

    public void deleteByNoticeId(Integer id) {
        MymallNoticeAdminExample example = new MymallNoticeAdminExample();
        example.or().andNoticeIdEqualTo(id).andDeletedEqualTo(false);
        MymallNoticeAdmin noticeAdmin = new MymallNoticeAdmin();
        noticeAdmin.setUpdateTime(LocalDateTime.now());
        noticeAdmin.setDeleted(true);
        noticeAdminMapper.updateByExampleSelective(noticeAdmin, example);
    }

    public void deleteByNoticeIds(List<Integer> ids) {
        MymallNoticeAdminExample example = new MymallNoticeAdminExample();
        example.or().andNoticeIdIn(ids).andDeletedEqualTo(false);
        MymallNoticeAdmin noticeAdmin = new MymallNoticeAdmin();
        noticeAdmin.setUpdateTime(LocalDateTime.now());
        noticeAdmin.setDeleted(true);
        noticeAdminMapper.updateByExampleSelective(noticeAdmin, example);
    }

    public int countReadByNoticeId(Integer noticeId) {
        MymallNoticeAdminExample example = new MymallNoticeAdminExample();
        example.or().andNoticeIdEqualTo(noticeId).andReadTimeIsNotNull().andDeletedEqualTo(false);
        return (int)noticeAdminMapper.countByExample(example);
    }

    public void updateByNoticeId(MymallNoticeAdmin noticeAdmin, Integer noticeId) {
        MymallNoticeAdminExample example = new MymallNoticeAdminExample();
        example.or().andNoticeIdEqualTo(noticeId).andDeletedEqualTo(false);
        noticeAdmin.setUpdateTime(LocalDateTime.now());
        noticeAdminMapper.updateByExampleSelective(noticeAdmin, example);
    }
}
