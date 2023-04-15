package org.biye.mymall.wx.service;

import org.biye.mymall.db.domain.MymallUser;
import org.biye.mymall.db.service.MymallUserService;
import org.biye.mymall.wx.dto.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class UserInfoService {
    @Autowired
    private MymallUserService userService;


    public UserInfo getInfo(Integer userId) {
        MymallUser user = userService.findById(userId);
        Assert.state(user != null, "用户不存在");
        UserInfo userInfo = new UserInfo();
        userInfo.setNickName(user.getNickname());
        userInfo.setAvatarUrl(user.getAvatar());
        return userInfo;
    }
}
