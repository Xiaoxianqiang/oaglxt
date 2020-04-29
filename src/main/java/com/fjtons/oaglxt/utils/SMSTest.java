package com.fjtons.oaglxt.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class SMSTest {

    private static final String addr = "http://api.sms.cn/sms/";
    private static final String userId = "xxq1500480314";

    /*
    * 如uid是：test，登录密码是：123123
    pwd=md5(123123test),即
    pwd=b9887c5ebb23ebb294acab183ecf0769

    */
    private static final String pwd = "659273b29b653af2b59593986d276978";

    private static final String encode = "utf8";

    public static void send(String msgContent, String mobile) throws Exception {

//组建请求
        String straddr = addr +
                "?ac=send&uid="+userId+
                "&pwd="+pwd+
                "&mobile="+mobile+
                "&encode="+encode+
                "&content=" + msgContent;

//        http://api.sms.cn/sms/?ac=send
//            &uid=xxq1500480314&pwd=接口密码[获取密码]
//                &template=100006&mobile=填写要发送的手机号
//                &content={"code":"value"}

        straddr = addr +
                "?ac=send&uid="+userId+
                "&pwd="+pwd+
                "&template=100006&mobile="+mobile+
                "&content=" + msgContent;


        StringBuffer sb = new StringBuffer(straddr);
        System.out.println("URL:"+sb);

//发送请求
        URL url = new URL(sb.toString());
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        BufferedReader in = new BufferedReader(new InputStreamReader(
                url.openStream()));

//返回结果
        String inputline = in.readLine();
        System.out.println("Response:"+inputline);

    }


    public static void main(String[] args) {
        try {
            send("内容", "15260118747");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}