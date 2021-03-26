package com.example.jdbc.service;

import com.example.jdbc.pojo.Collection;
import com.example.jdbc.pojo.Delivery;
import com.example.jdbc.pojo.Job;

import java.util.List;

public interface JobService {
    //获取指定id信息
    Job getJobInfoById(String jobid);
    //获取全部信息
    List<Job> queryJobInfo();
    //筛选
    List<Job> selectJob(String jobname);
    List<Job> selectInfo(String st1,String str2,String st3,String str4,String st5,String str6);
    //删除
    boolean deleteJobInfoById(String jobid);
    //更新按照Id
    boolean updateJobInfoById(Job job);
    //重置
    boolean reset();
    //初始化col
    boolean initCol(String userid);
    //初始化del
    boolean initDel(String userid);
    //初始化col
    int getColNum(String userid);
    //初始化del
    int getDelNum(String userid);




    //添加
    boolean addColInfo(Collection collection);
    //删除
    boolean deleteColById(String jobid,String userid);
    //获取指定一条收藏信息
    Collection getColById(String jobid,String userid);
    //获取一个用户的收藏列表
    List<Collection> getColByUserId(String userid);
    //重置
    boolean resetCol();
    //初始化收藏
    boolean initColStatus();
    //初始化col
    boolean initColDel(String userid);
    //筛选
    List<Collection> selectCol(String jobname);


    //初始化收藏
    boolean initDelStatus();
    //添加
    boolean addDelInfo(Delivery delivery);
    //更新投递
    boolean updateRecycle(Delivery delivery);
    //更新投递
    boolean updateDelTime(Delivery delivery);
    //删除
    boolean deleteDelById(String jobid,String userid);
    //获取指定一条投递信息
    Delivery getDelById(String jobid,String userid);
    //获取一个用户的投递列表
    List<Delivery> getDelByUserId(String userid);

}