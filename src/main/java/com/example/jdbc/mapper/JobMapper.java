package com.example.jdbc.mapper;

import com.example.jdbc.pojo.Collection;
import com.example.jdbc.pojo.Delivery;
import com.example.jdbc.pojo.Job;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface JobMapper {

    List<Job> queryJobInfo();
    Job getJobInfoById(String jobid) ;
    int deleteJobInfoById(String jobid);
    int updateJobInfoById(Job job);
    int reset();
    int initCol(String id);
    int initDel(String id);
    int getColNum(String userid);
    int getDelNum(String userid);
    List<Job> selectJob(String jobname);
    List<Job> selectInfo(String str1,String str2,String str3,String str4,String str5,String str6);


    List<Collection> selectCol(String jobname);
    int resetCol();
    int initColDel(String id);
    int initColStatus();
    int addColInfo(Collection collection);
    int deleteColById(String jobid,String userid);
    Collection getColById(String jobid,String userid) ;
    List<Collection> getColByUserId(String userid);


    int initDelStatus();
    int addDelInfo(Delivery delivery);
    int updateRecycle(Delivery delivery);
    int updateDelTime(Delivery delivery);
    int deleteDelById(String jobid,String userid);
    Delivery getDelById(String jobid,String userid) ;
    List<Delivery> getDelByUserId(String userid);
}