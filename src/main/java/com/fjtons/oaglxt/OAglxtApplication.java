package com.fjtons.oaglxt;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OAglxtApplication {

    public static void main(String[] args) {
        SpringApplication.run(OAglxtApplication.class, args);
    }
//页面信息设置
    //signedList  项目的签订，未签订，外包信息文件夹
        //notSignedproject-list.html  未签订信息
        //OutsourcingProject_list.html  外包信息
        //signedproject-list.html   签订信息
        //signedproject-updata.html  修改签订信息
        //outsourcingProject_update.html  修改外包信息
    //projectClassification  签订项目的分类
        // dockingProject_list.html  对接项目
        //notDockingProjiect_list.html  未对接项目
        //landingProject_list.html   落地项目
        //completeProject_list.html 完成项目
        //terminationProject_list.html  终止项目
    //用户管理   User        userControl
}
