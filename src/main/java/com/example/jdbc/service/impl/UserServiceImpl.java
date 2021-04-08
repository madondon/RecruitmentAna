package com.example.jdbc.service.impl;

import com.example.jdbc.mapper.UserMapper;
import com.example.jdbc.pojo.User;
import com.example.jdbc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User getNumber(String number) { return userMapper.getNumber(number); }

    @Override
    public User getUserInfoById(int id) { return userMapper.getUserInfoById(id); }

    @Override
    public List<User> queryUserInfo() { return userMapper.queryUserInfo(); }

    @Override
    public boolean deleteUserInfoById(int id) {
        try {
            //对mysql数据库做删除操作后，影响的行数effecteNum
            int effecteNum= userMapper.deleteUserInfoById(id);
            if (effecteNum>0){
                return true;
            }else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Transactional
    @Override
    public boolean addUserInfo(User user) {
            try{
                //对mysql数据库做增加操作后，影响的行数effecteNum
                int effecteNum= userMapper.addUserInfo(user);
                if(effecteNum>0){
                    //如果影响行数大于0，那么就是增加成功
                    System.out.println("增加成功，主键为："+user.getId());
                    return true;
                }else {
                    throw  new RuntimeException("插入信息失败,插入行数有误");
                }
            }catch (Exception e){
                throw  new RuntimeException("插入信息失败了:"+e.getMessage());
            }
    }

    @Transactional
    @Override
    public boolean updateAdmin(User user) {
            try{
                //对mysql数据库做更新操作后，影响的行数effecteNum
                int effecteNum= userMapper.updateAdmin(user);

                if(effecteNum>0){
                    //如果影响行数大于0，那么就是更新成功
                    System.out.println("更新成功，主键为："+user.getId());
                    return true;
                }else {
                    throw  new RuntimeException("更新信息失败,插入行数有误");
                }
            }catch (Exception e){
                throw  new RuntimeException("更新信息失败了:"+e.getMessage());
            }
    }

    @Transactional
    @Override
    public boolean updatePassword(User user) {
            try{
                //对mysql数据库做更新操作后，影响的行数effecteNum
                int effecteNum= userMapper.updatePassword(user);

                if(effecteNum>0){
                    //如果影响行数大于0，那么就是更新成功
                    System.out.println("更新成功，主键为："+user.getId());
                    return true;
                }else {
                    throw  new RuntimeException("更新信息失败,插入行数有误");
                }
            }catch (Exception e){
                throw  new RuntimeException("更新信息失败了:"+e.getMessage());
            }
    }

    @Transactional
    @Override
    public boolean updatePicture(User user) {
            try{
                //对mysql数据库做更新操作后，影响的行数effecteNum
                int effecteNum= userMapper.updatePicture(user);

                if(effecteNum>0){
                    //如果影响行数大于0，那么就是更新成功
                    System.out.println("更新成功，主键为："+user.getId());
                    return true;
                }else {
                    throw  new RuntimeException("更新信息失败,插入行数有误");
                }
            }catch (Exception e){
                throw  new RuntimeException("更新信息失败了:"+e.getMessage());
            }
    }

    @Transactional
    @Override
    public boolean updateUserInfoById(User user) {
            try{
                //对mysql数据库做更新操作后，影响的行数effecteNum
                int effecteNum= userMapper.updateUserInfoById(user);

                if(effecteNum>0){
                    //如果影响行数大于0，那么就是更新成功
                    System.out.println("更新成功，主键为："+user.getId());
                    return true;
                }else {
                    throw  new RuntimeException("更新信息失败,插入行数有误");
                }
            }catch (Exception e){
                throw  new RuntimeException("更新信息失败了:"+e.getMessage());
            }
    }
}
