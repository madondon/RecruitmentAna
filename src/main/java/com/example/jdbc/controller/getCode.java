package com.example.jdbc.controller;

import com.alibaba.fastjson.JSONObject;
import com.zhenzi.sms.ZhenziSmsClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class getCode {
    @ResponseBody
    @GetMapping("/fitness/code")
    public static String getCode(@RequestParam("memPhone") String memPhone){
        //短信平台相关参数
        //这个不用改
         String apiUrl = "https://sms_developer.zhenzikj.com";
        //榛子云系统上获取
         String appId = "108529";
         String appSecret = "e1008b7c-f74e-4f00-bead-0a1f57483e2b";
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
                return  "getCode false";
            }
            return code;
        } catch (Exception e) {
            e.printStackTrace();
            return "getCode false";
        }
    }
}
