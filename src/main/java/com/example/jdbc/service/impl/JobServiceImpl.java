package com.example.jdbc.service.impl;

import com.example.jdbc.mapper.JobMapper;
import com.example.jdbc.pojo.Collection;
import com.example.jdbc.pojo.Delivery;
import com.example.jdbc.pojo.Job;
import com.example.jdbc.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class JobServiceImpl implements JobService {

    @Autowired
    JobMapper jobMapper;

    @Override
    public Job getJobInfoById(String jobid) { return jobMapper.getJobInfoById(jobid); }

    @Override
    public List<Job> queryJobInfo() { return jobMapper.queryJobInfo(); }

    @Override
    public List<Job> selectJob(String jobname) { return jobMapper.selectJob(jobname); }

    @Override
    public List<Job> selectInfo(String str1,String str2,String str3,String str4,String str5,String str6) { return jobMapper.selectInfo(str1,str2,str3,str4,str5,str6); }

    @Override
    public boolean deleteJobInfoById(String id) {
        try {
            //对mysql数据库做删除操作后，影响的行数effecteNum
            int effecteNum= jobMapper.deleteJobInfoById(id);
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
    public boolean updateJobInfoById(Job job) {
        try{
            //对mysql数据库做更新操作后，影响的行数effecteNum
            int effecteNum= jobMapper.updateJobInfoById(job);

            if(effecteNum>0){
                //如果影响行数大于0，那么就是更新成功
                System.out.println("更新成功，主键为："+job.getJobid());
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
    public boolean reset() {
        try{
            //对mysql数据库做更新操作后，影响的行数effecteNum
            int effecteNum= jobMapper.reset();

            if(effecteNum>0){
                //如果影响行数大于0，那么就是更新成功
                System.out.println("更新成功");
                return true;
            }else {
                throw  new RuntimeException("更新信息失败,插入行数有误");
            }
        }catch (Exception e){
            throw  new RuntimeException("更新信息失败了:"+e.getMessage());
        }
    }

    @Override
    public boolean initDel(String id) {
        try {
            int effecteNum= jobMapper.initDel(id);
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

    @Override
    public boolean initCol(String id) {
        try {
            int effecteNum= jobMapper.initCol(id);
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

    @Override
    public int getColNum(String id) { return jobMapper.getColNum(id); }

    @Override
    public int getDelNum(String id) { return jobMapper.getDelNum(id); }




    @Override
    public List<Collection> selectCol(String jobname) { return jobMapper.selectCol(jobname); }

    @Transactional
    @Override
    public boolean resetCol() {
        try{
            //对mysql数据库做更新操作后，影响的行数effecteNum
            int effecteNum= jobMapper.resetCol();

            if(effecteNum>0){
                //如果影响行数大于0，那么就是更新成功
                System.out.println("更新成功");
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
    public boolean initColStatus() {
        try{
            //对mysql数据库做更新操作后，影响的行数effecteNum
            int effecteNum= jobMapper.initColStatus();

            if(effecteNum>0){
                //如果影响行数大于0，那么就是更新成功
                System.out.println("更新成功");
                return true;
            }else {
                throw  new RuntimeException("更新信息失败,插入行数有误");
            }
        }catch (Exception e){
            throw  new RuntimeException("更新信息失败了:"+e.getMessage());
        }
    }

    @Override
    public boolean initColDel(String id) {
        try {
            int effecteNum= jobMapper.initColDel(id);
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
    public boolean initDelStatus() {
        try{
            //对mysql数据库做更新操作后，影响的行数effecteNum
            int effecteNum= jobMapper.initDelStatus();

            if(effecteNum>0){
                //如果影响行数大于0，那么就是更新成功
                System.out.println("更新成功");
                return true;
            }else {
                throw  new RuntimeException("更新信息失败,插入行数有误");
            }
        }catch (Exception e){
            throw  new RuntimeException("更新信息失败了:"+e.getMessage());
        }
    }

    @Override
    public Collection getColById(String jobid, String userid) { return jobMapper.getColById(jobid,userid); }

    @Override
    public  List<Collection> getColByUserId(String userid) { return jobMapper.getColByUserId(userid); }

    @Override
    public boolean deleteColById(String id,String userid) {
        try {
            //对mysql数据库做删除操作后，影响的行数effecteNum
            int effecteNum= jobMapper.deleteColById(id,userid);
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
    public boolean addColInfo(Collection collection) {
        try{
            //对mysql数据库做增加操作后，影响的行数effecteNum
            int effecteNum= jobMapper.addColInfo(collection);
            if(effecteNum>0){
                //如果影响行数大于0，那么就是增加成功
                System.out.println("增加成功");
                return true;
            }else {
                throw  new RuntimeException("插入信息失败,插入行数有误");
            }
        }catch (Exception e){
            throw  new RuntimeException("插入信息失败了:"+e.getMessage());
        }
    }






    @Override
    public Delivery getDelById(String jobid,String userid) { return jobMapper.getDelById(jobid,userid); }

    @Override
    public  List<Delivery> getDelByUserId(String userid) { return jobMapper.getDelByUserId(userid); }

    @Override
    public boolean deleteDelById(String id,String userid) {
        try {
            //对mysql数据库做删除操作后，影响的行数effecteNum
            int effecteNum= jobMapper.deleteDelById(id,userid);
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
    public boolean addDelInfo(Delivery delivery) {
        try{
            //对mysql数据库做增加操作后，影响的行数effecteNum
            int effecteNum= jobMapper.addDelInfo(delivery);
            if(effecteNum>0){
                //如果影响行数大于0，那么就是增加成功
                System.out.println("增加成功，主键为："+delivery.getJobid());
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
    public boolean updateRecycle(Delivery delivery) {
        try{
            //对mysql数据库做更新操作后，影响的行数effecteNum
            int effecteNum= jobMapper.updateRecycle(delivery);
            if(effecteNum>0){
                //如果影响行数大于0，那么就是更新成功
                System.out.println("更新成功");
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
    public boolean updateDelTime(Delivery delivery) {
        try{
            //对mysql数据库做更新操作后，影响的行数effecteNum
            int effecteNum= jobMapper.updateDelTime(delivery);
            if(effecteNum>0){
                //如果影响行数大于0，那么就是更新成功
                System.out.println("更新成功");
                return true;
            }else {
                throw  new RuntimeException("更新信息失败,插入行数有误");
            }
        }catch (Exception e){
            throw  new RuntimeException("更新信息失败了:"+e.getMessage());
        }
    }

}
