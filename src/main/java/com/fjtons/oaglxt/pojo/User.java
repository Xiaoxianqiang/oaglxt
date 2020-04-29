/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: user
 * Author:   abc
 * Date:     2020/2/12 14:12
 * Description: user
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.fjtons.oaglxt.pojo;

import lombok.Data;

import java.util.Date;

/**
 * 〈用户信息对象〉<br>
 * 〈user〉
 *
 * @author abc
 * @create 2020/2/12
 * @since 1.0.0
 */
@Data
public class User {
private  String account;//账号   3到9位不超过十一位
private  String password;//密码
private  String name;//姓名
private  String sex;//性别  1：男  2：女
private String regtime;//用户注册时间
private  String phone;//用户手机号  登录方式之一
private  String permissions;//用户权限  1.超级管理 2.负责人 3.普通用户
//部门  部门先不设置
private String  departmentId;//部门id
    private Department department;//部门id
private  String canvas;//验证码    只在登录时用到平时没有用private Department department;
}