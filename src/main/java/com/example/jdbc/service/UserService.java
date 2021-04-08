package com.example.jdbc.service;

import com.example.jdbc.pojo.User;

import java.util.List;

public interface UserService {
    //获取指定id信息
    User getNumber(String number);
    //获取全部信息
    List<User> queryUserInfo();
    //获取指定id信息
    User getUserInfoById(int id);
    //添加
    boolean addUserInfo(User user);
    //更新用户基本信息
    boolean updateUserInfoById(User user);
    //更新密码
    boolean updatePassword(User user);
    //更新图片
    boolean updatePicture(User user);
    //更新管理员
    boolean updateAdmin(User user);
    //删除
    boolean deleteUserInfoById(int id);

}