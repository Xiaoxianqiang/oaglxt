package com.fjtons.oaglxt.utils;

import org.springframework.util.ClassUtils;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

public class DataUtil {
    public final static String fomatDateTime1 = "yyyy-MM-dd hh:mm:ss";
    public final static String fomatDateTime2 = "yyyyMMddhhmmss";
    public final static String fomatDate1 = "yyyy-MM-dd";


    /**
     * 格式化时间 "yyyy-MM-dd hh:mm:ss"
     * @param date
     * @return
     */
    public static String getFomatTime(Date date){
        String formatTime = new SimpleDateFormat(fomatDateTime1).format(date);
        return formatTime;
    }

    /**
     * 得到当前月份 "yyyy-MM"
     * @return
     */
    public static String getNowDate(){
        String formatDate = new SimpleDateFormat(fomatDateTime1).format(new Date());
        return formatDate;
    }
    /**
     * 获取时间戳
     */
    public  static  String getTimeUUID(){
        String startTs = System.currentTimeMillis()+"";
        return  startTs;
    }
    // 项目根路径下的目录  -- SpringBoot static 目录相当于是根路径下（SpringBoot 默认）
    public final static String IMG_PATH_PREFIX = "static/projectImg";
    /**
     * 图片路径上传
     */
    public static File getImgDirFile(){

        // 构建上传文件的存放 "文件夹" 路径
       // String fileDirPath = new String("src/main/resources/" + IMG_PATH_PREFIX);
        String fileDirPath =   ClassUtils.getDefaultClassLoader().getResource("static").getPath()+"/projectImg";
        Date date = new Date();
        String uuid = UUID.randomUUID()+"";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        fileDirPath+="/"+simpleDateFormat.format(date);
        File fileDir = new File(fileDirPath);
        if(!fileDir.exists()){
            // 递归生成文件夹
            fileDir.mkdirs();
        }
        return fileDir;
    }

}
