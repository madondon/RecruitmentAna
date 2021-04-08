package com.example.jdbc.controller;

import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class Address {
    //使用腾讯的接口通过ip拿到城市信息
    public static String getCityInfo(String str)  {
        String s = sendGet(str);
        Map map = JSONObject.parseObject(s, Map.class);
        String message = (String) map.get("message");
        if("query ok".equals(message)){
            Map result = (Map) map.get("result");
            Map location = (Map) result.get("location");
            String lng = String.valueOf(location.get("lng")) ;
            String lat = String.valueOf(location.get("lat")) ;
            String address =  lng + "-" + lat ;
            return address;
        }else{
            System.out.println(message);
            return null;
        }
    }
    //根据在腾讯位置服务上申请的key进行请求操作
    public static String sendGet(String str) {
        String result = "";
        BufferedReader in = null;
        try {
            String urlNameString = "https://apis.map.qq.com/ws/geocoder/v1/?address="+str+"&key=F6YBZ-2UCL2-UGRUF-CSKMY-AU222-OEBRZ";
            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
//            for (Map.Entry entry : map.entrySet()) {
//                System.out.println(key + "--->" + entry);
//            }
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result;
    }

}

