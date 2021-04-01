package com.example.jdbc.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.jdbc.pojo.*;
import com.example.jdbc.pojo.Collection;
import com.example.jdbc.service.MailService;
import com.example.jdbc.service.impl.AnaServiceImpl;
import com.example.jdbc.service.impl.JobServiceImpl;
import com.example.jdbc.service.impl.UserServiceImpl;
import com.zhenzi.sms.ZhenziSmsClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.mail.javamail.JavaMailSender;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.*;


@CrossOrigin(origins = "*",maxAge = 3600)//跨域
@RestController
public class Controller {
    @Autowired
    UserServiceImpl userService;
    @Autowired
    JobServiceImpl jobService;
    @Autowired
    AnaServiceImpl anaService;
    @Autowired
    private MailService mailService;


    /**
     * 图表类
     */
    @CrossOrigin(origins = "*",maxAge = 3600)//跨域
    @RestController
    public class AnaController {
        /**
         * 查询所有工作信息
         */
        @GetMapping("/getAna1")
        public List getAna1() {
            return anaService.getAna1();
        }

        @GetMapping("/getAna2")
        public List getAna2() {
            return anaService.getAna2();
        }

        @GetMapping("/getAna3")
        public List getAna3() {
            return anaService.getAna3();
        }

        @GetMapping("/getAna4")
        public List getAna4() {
            return anaService.getAna4();
        }

        @GetMapping("/getAna5")
        public List getAna5() {
            return anaService.getAna5();
        }

        @GetMapping("/getAna6")
        public List getAna6() {
            return anaService.getAna6();
        }

        @GetMapping("/getAna7")
        public List getAna7() {
            return anaService.getAna7();
        }

        @GetMapping("/getAna8")
        public List getAna8() {
            return anaService.getAna8();
        }

        @GetMapping("/getAna9")
        public List getAna9() {
            return anaService.getAna9();
        }

        @GetMapping("/getAna10")
        public List getAna10() {
            return anaService.getAna10();
        }

    }


    /**
     * 工作类
     */
    @CrossOrigin(origins = "*",maxAge = 3600)//跨域
    @RestController
    public class JobController {
        /**
         * 查询所有工作信息
         */
        @GetMapping("/queryJobInfo")
        public List queryJobInfo() {
            return jobService.queryJobInfo();
        }

        /**
         * 筛选工作信息
         */
        @GetMapping("/selectJob/{jobname}")
        public List selectJob(@PathVariable("jobname") String jobname) {
            return jobService.selectJob(jobname);
        }

        /**
         * 复杂筛选工作信息
         */
        @PostMapping("/selectInfo")
        public List selectInfo(@RequestBody Map<String, String> jobMap) {
            return jobService.selectInfo(jobMap.get("workarea"),jobMap.get("money"),jobMap.get("experience"),jobMap.get("degreefrom"),jobMap.get("cotype"),jobMap.get("cosize"));
        }

        /**
         * 按照Id查询工作信息
         */
        @GetMapping("/getJobInfoById/{jobid}")
        public Job getJobInfoById(@PathVariable("jobid") String jobid) {
            return jobService.getJobInfoById(jobid);
        }

        /**
         * 删除工作信息
         */
        @DeleteMapping("/deleteJobInfoById/{jobid}")
        public String deleteJobInfoById(@PathVariable("jobid") String jobid) {

            boolean result = jobService.deleteJobInfoById(jobid);
            if (result) {
                return "success";
            } else {
                return "fail";
            }
        }

        /**
         * 更新工作信息
         */
        @PostMapping("/updateJobInfoById")
        public String updateJobInfoById(@RequestBody Map<String, String> jobMap) {
            Date date = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Job job = new Job();
            job.setJobid(jobMap.get("jobid"));
            job.setName(jobMap.get("name"));
            job.setMoney(jobMap.get("money"));
            job.setWorkarea(jobMap.get("workarea"));
            job.setConame(jobMap.get("coname"));
            job.setCotype(jobMap.get("cotype"));
            job.setCosize(jobMap.get("cosize"));
            job.setJobwelf(jobMap.get("jobwelf"));
            job.setExperience(jobMap.get("experoence"));
            job.setDegreefrom(jobMap.get("degreefrom"));
            job.setNum(jobMap.get("num"));
            job.setContent(jobMap.get("content"));
            job.setUpdatedate(dateFormat.format(date));
            boolean result = jobService.updateJobInfoById(job);
            if (result) {
                return "success";
            } else {
                return "fail";
            }
        }

        /**
         * 重置
         */
        @PostMapping("/reset")
        public String reset() {

            boolean result = jobService.reset();
            if (result) {
                return "success";
            } else {
                return "fail";
            }
        }

        /**
         * 初始化收藏
         */
        @PostMapping("/initCol/{userid}")
        public String initCol(@PathVariable("userid") String userid) {

            boolean result = jobService.initCol(userid);
            if (result) {
                return "success";
            } else {
                return "fail";
            }
        }

        /**
         * 初始化投递
         */
        @PostMapping("/initDel/{userid}")
        public String initDel(@PathVariable("userid") String userid) {

            boolean result = jobService.initDel(userid);
            if (result) {
                return "success";
            } else {
                return "fail";
            }
        }

        /**
         * 查询收藏数量
         */
        @GetMapping("/getColNum/{userid}")
        public int getColNum(@PathVariable("userid") String userid) {
            return jobService.getColNum(userid);
        }

        /**
         * 查询投递数量
         */
        @GetMapping("/getDelNum/{userid}")
        public int getDelNum(@PathVariable("userid") String userid) {
            return jobService.getDelNum(userid);
        }






        /**
         * 按照Id查询投递信息
         */
        @GetMapping("/getDelById/{jobid}/{userid}")
        public Delivery getDelById(@PathVariable("jobid") String jobid,@PathVariable("userid") String userid) {
            return jobService.getDelById(jobid,userid);
        }

        /**
         * 按照用户Id查询投递信息
         */
        @GetMapping("/getDelByUserId/{userid}")
        public List<Delivery> getDelByUserId(@PathVariable("userid") String userid) {
            jobService.initDelStatus();
            return jobService.getDelByUserId(userid);
        }

        /**
         * 删除投递信息
         */
        @DeleteMapping("/deleteDelById/{jobid}/{userid}")
        public String deleteDelById(@PathVariable("jobid") String jobid,@PathVariable("userid") String userid) {
            boolean result = jobService.deleteDelById(jobid,userid);
            if (result) {
                return "success";
            } else {
                return "fail";
            }
        }

        /**
         * 增加投递信息
         */
        @PostMapping("/addDelInfo")
        public String addDelInfo(@RequestBody Map<String, String> jobMap) {
            Date date = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            System.out.println(dateFormat.format(date));

            Delivery delivery=new Delivery();
            delivery.setJobid(jobMap.get("jobid"));
            delivery.setUserid(jobMap.get("userid"));
            delivery.setName(jobMap.get("name"));
            delivery.setConame(jobMap.get("coname"));
            delivery.setMoney(jobMap.get("money"));
            delivery.setWorkarea(jobMap.get("workarea"));
            delivery.setUpdatedate(dateFormat.format(date));
            try {
                boolean result = jobService.addDelInfo(delivery);
                if (result) {
                    return "success";
                } else {
                    return "fail";
                }
            } catch (Exception e) {
                return "fail";
            }
        }

        /**
         * 更新回收
         */
        @PostMapping("/updateRecycle")
        public String updateRecycle(@RequestBody Map<String, String> jobMap) {
            Delivery delivery = new Delivery();
            delivery.setJobid(jobMap.get("jobid"));
            delivery.setUserid(jobMap.get("userid"));
            Delivery del1 = jobService.getDelById(delivery.getJobid(),delivery.getUserid());
            if (del1.getRecycle() == 1)
                delivery.setRecycle(0);
            else
                delivery.setRecycle(1);
            boolean result = jobService.updateRecycle(delivery);

            if (result) {

                return "success";
            } else {
                return "fail";
            }
        }

        /**
         * 更新投递时间
         */
        @PostMapping("/updateDelTime")
        public String updateDelTime(@RequestBody Map<String, String> jobMap) {
            Date date = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            System.out.println(dateFormat.format(date));
            Delivery delivery = new Delivery();
            delivery.setJobid(jobMap.get("jobid"));
            delivery.setUserid(jobMap.get("userid"));
            delivery.setUpdatedate(dateFormat.format(date));
            boolean result = jobService.updateDelTime(delivery);
            if (result) {
                return "success";
            } else {
                return "fail";
            }
        }






        /**
         * 筛选工作信息
         */
        @GetMapping("/selectCol/{jobname}")
        public List selectCol(@PathVariable("jobname") String jobname) {
            return jobService.selectCol(jobname);
        }

        /**
         * 按照Id查询收藏信息
         */
        @GetMapping("/getColById/{jobid}/{userid}")
        public Collection getColById(@PathVariable("jobid") String jobid,@PathVariable("userid") String userid) {
            return jobService.getColById(jobid,userid);
        }

        /**
         * 按照用户Id查询收藏信息列表
         */
        @GetMapping("/getColByUserId/{userid}")
        public List<Collection> getColByUserId(@PathVariable("userid") String userid) {
            jobService.initColStatus();
            return jobService.getColByUserId(userid);
        }

        /**
         * 删除收藏信息
         */
        @DeleteMapping("/deleteColById/{jobid}/{userid}")
        public String deleteColById(@PathVariable("jobid") String jobid,@PathVariable("userid") String userid) {
            boolean result = jobService.deleteColById(jobid,userid);
            if (result) {
                return "success";
            } else {
                return "fail";
            }
        }

        /**
         * 增加收藏信息
         */
        @PostMapping("/addColInfo")
        public String addColInfo(@RequestBody Map<String, String> jobMap) {
            Date date = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            System.out.println(dateFormat.format(date));

            Collection collection=new Collection();
            collection.setJobid(jobMap.get("jobid"));
            collection.setUserid(jobMap.get("userid"));
            collection.setCoid(jobMap.get("coid"));
            collection.setName(jobMap.get("name"));
            collection.setMoney(jobMap.get("money"));
            collection.setWorkarea(jobMap.get("workarea"));
            collection.setConame(jobMap.get("coname"));
            collection.setCotype(jobMap.get("cotype"));
            collection.setCosize(jobMap.get("cosize"));
            collection.setJobwelf(jobMap.get("jobwelf"));
            collection.setExperience(jobMap.get("experience"));
            collection.setDegreefrom(jobMap.get("degreefrom"));
            collection.setNum(jobMap.get("num"));
            collection.setContent(jobMap.get("content"));
            collection.setUpdatedate(dateFormat.format(date));
            try {
                boolean result = jobService.addColInfo(collection);
                if (result) {
                    return "success";
                } else {
                    return "fail";
                }
            } catch (Exception e) {
                return "fail";
            }
        }

        /**
         * 重置
         */
        @PostMapping("/resetCol")
        public String resetCol() {
            boolean result = jobService.resetCol();
            if (result) {
                return "success";
            } else {
                return "fail";
            }
        }


        /**
         * 初始化收藏表的是否投递
         */
        @PostMapping("/initColDel/{userid}")
        public String initColDel(@PathVariable("userid") String userid) {
            boolean result = jobService.initColDel(userid);
            if (result) {
                return "success";
            } else {
                return "fail";
            }
        }
    }



    /**
     * 用户类
     */
    @CrossOrigin(origins = "*",maxAge = 3600)//跨域
    @RestController
    public class UserController {
    /**
     * 增加用户信息
     */
    @PostMapping("/addUserInfo")
    public String addUserInfo(@RequestBody Map<String, String> userMap) {
        User user = new User();
        user.setId(Integer.parseInt(userMap.get("id")));
        user.setPassword(userMap.get("password"));
        user.setName(userMap.get("name"));
        user.setIdentity(userMap.get("identity"));
        user.setSex(userMap.get("sex"));
        user.setEducation(userMap.get("education"));
        user.setBirthday(userMap.get("birthday"));
        user.setPhone(userMap.get("phone"));
        user.setMail(userMap.get("mail"));
        user.setWordKey(userMap.get("wordKey"));
        try {
            boolean result = userService.addUserInfo(user);
            if (result) {
                return "success";
            } else {
                return "fail";
            }
        } catch (Exception e) {
            return "fail";
        }
    }

    /**
     * 更新用户头像
     */
    @PostMapping("/updatePicture")
    public String updatePicture(@RequestBody Map<String, String> userMap) {
        User user = new User();
        user.setId(Integer.parseInt(userMap.get("id")));
        user.setPicture(userMap.get("picture"));
        boolean result = userService.updatePicture(user);
        if (result) {
            return "success";
        } else {
            return "fail";
        }
    }

    /**
     * 更新用户密码
     */
    @PostMapping("/updatePassword")
    public String updatePassword(@RequestBody Map<String, String> userMap) {
        User user = new User();
        user.setId(Integer.parseInt(userMap.get("id")));
        user.setPassword(userMap.get("password"));
        boolean result = userService.updatePassword(user);
        if (result) {
            return "success";
        } else {
            return "fail";
        }
    }

    /**
     * 更新管理员
     */
    @PostMapping("/updateAdmin")
    public String updateAdmin(@RequestBody Map<String, String> userMap) {
        User user = new User();
        user.setId(Integer.parseInt(userMap.get("id")));
        User user1 = userService.getUserInfoById(user.getId());
        if (user1.getAdmin().equals("是"))
            user.setAdmin("否");
        else
            user.setAdmin("是");
        boolean result = userService.updateAdmin(user);
        if (result) {
            return "success";
        } else {
            return "fail";
        }
    }

    /**
     * 更新用户基本信息
     */
    @PostMapping("/updateUserInfoById")
    public String updateUserInfoById(@RequestBody Map<String, String> userMap) {
        User user = new User();
        user.setId(Integer.parseInt(userMap.get("id")));
        user.setName(userMap.get("name"));
        user.setIdentity(userMap.get("identity"));
        user.setSex(userMap.get("sex"));
        user.setEducation(userMap.get("education"));
        user.setBirthday(userMap.get("birthday"));
        user.setPhone(userMap.get("phone"));
        user.setMail(userMap.get("mail"));
        user.setWordKey(userMap.get("wordKey"));
        boolean result = userService.updateUserInfoById(user);
        if (result) {
            return "success";
        } else {
            return "fail";
        }
    }

    /**
     * 删除用户信息
     */
    @DeleteMapping("/deleteUserInfoById/{id}")
    public String deleteUserInfoById(@PathVariable("id") int id) {

        boolean result = userService.deleteUserInfoById(id);
        if (result) {
            return "success";
        } else {
            return "fail";
        }
    }

    /**
     * 按照Id查询用户信息
     */
    @GetMapping("/getUserInfoById/{id}")
    public User getUserInfoById(@PathVariable("id") int id) {
        return userService.getUserInfoById(id);
    }

    /**
     * 查询所有用户信息
     */
    @GetMapping("/queryUserInfo")
    public List queryUserInfo() {
        return userService.queryUserInfo();
    }

}



    /**
     * 工具类
     */
    @CrossOrigin(origins = "*",maxAge = 3600)//跨域
    @RestController
    public class ToolController {
        @GetMapping("/sendMail")
        public String sendMail() {
            String filePath="C:\\Users\\mdd\\Desktop\\新建 DOCX 文档.docx";
            mailService.sendAttachmentsMail("a1224641706@163.com","带附件的邮件","有附件，请查收",filePath);
            return "success";
        }

        /**
         * 上传图片到本地文件夹
         */
        @PostMapping(value = "/upload")
        // @RequestParam中的file名应与前端的值保持一致
        public String upload(@RequestParam("file") MultipartFile multipartFile) {
            // replaceAll 用来替换windows中的\\ 为 /
            System.out.println(multipartFile.getOriginalFilename());
            return FileUploadUtil.upload(multipartFile).replaceAll("\\\\", "/");
        }

        /**
         * 根据ip获取定位
         */
        @GetMapping(value = "/location")
        public String location() {
            System.out.println(IpToAddressUtil.getCityInfo());
            return IpToAddressUtil.getCityInfo();
        }

        //短信平台相关参数
        //这个不用改
        private String apiUrl = "https://sms_developer.zhenzikj.com";
        //榛子云系统上获取
        private String appId = "108529";
        private String appSecret = "e1008b7c-f74e-4f00-bead-0a1f57483e2b";

        @ResponseBody
        @GetMapping("/fitness/code")
        public boolean getCode(@RequestParam("memPhone") String memPhone, HttpSession httpSession){
            try {
                //随机生成验证码
                String code = String.valueOf(new Random().nextInt(999999));
                //将验证码通过榛子云接口发送至手机
                ZhenziSmsClient client = new ZhenziSmsClient(apiUrl, appId, appSecret);
                Map<String, Object> params = new HashMap<String, Object>();
                params.put("number",memPhone);
                params.put("templateId", "4353");
                String[] templateParams = new String[2];
                templateParams[0] = code;
                templateParams[1] = "5分钟";
                params.put("templateParams", templateParams);
                String result = client.send(params);
                JSONObject json = JSONObject.parseObject(result);
                if (json.getIntValue("code")!=0){//发送短信失败
                    return  false;
                }
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }

    }
}
