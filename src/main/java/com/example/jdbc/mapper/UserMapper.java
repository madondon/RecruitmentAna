package com.example.jdbc.mapper;

import com.example.jdbc.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    List<User> queryUserInfo() ;
    User getUserInfoById(int id) ;
    int updatePassword(User user);
    int updateAdmin(User user);
    int updatePicture(User user);
    int updateUserInfoById(User user);
    int deleteUserInfoById(int id);
    int addUserInfo(User user);
}