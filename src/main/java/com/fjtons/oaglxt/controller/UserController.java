/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: userController
 * Author:   abc
 * Date:     2020/2/12 16:01
 * Description: userController
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.fjtons.oaglxt.controller;

import com.fjtons.oaglxt.pojo.PageRequest;
import com.fjtons.oaglxt.pojo.User;
import com.fjtons.oaglxt.service.UserService;
import com.fjtons.oaglxt.utils.MD5Util;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * 〈用户〉<br>
 * 〈userController〉
 *
 * @author abc
 * @create 2020/2/12
 * @since 1.0.0
 */
@Controller
@RequestMapping("/User")
public class UserController {
    @Resource
    private UserService userService;
    /**
     * 获取分页
     * @param  page, limit
     * @return
     * page=1&limit=10
     */
    @RequestMapping(value="/selectPage")
    @ResponseBody
    public Object selectPage(int page,int limit,User user) {
        //需要判断自己得权限
        PageRequest pageQuery=new PageRequest();
        pageQuery.setPageNum(page);
        pageQuery.setPageSize(limit);
        return userService.selectPage(pageQuery,user);
    }



   //获取登入用户信息
    @RequestMapping("getLoginUser")
    @ResponseBody
    public  Object getLoginUser(HttpSession session){
        User user=(User) session.getAttribute("loginUser");
        return user;
    }
    /**
     * 修改密码
     */
    @RequestMapping("replacePassword")
    @ResponseBody
    public  Object replacePassword(String oldpass,String pass){
        return  userService.replacePassword(oldpass, pass);
    }

    /**
     *
     * @return
     */
    //queryUserResponsible
    @RequestMapping("/queryUserResponsible")
    @ResponseBody
    public  Object queryUserResponsible(){
        return  userService.queryUserResponsible();
    }
    @RequestMapping("/insertUser")
    @ResponseBody
    public  int insertUser(User user){
        return  userService.insertUser(user);
    }
    @RequestMapping("/updateUser")
    @ResponseBody
    public  Object updateUser(User user){
        return  userService.updateUser(user);
    }
    @RequestMapping("/deleteArrayUser")
    @ResponseBody
    public  Object deleteArrayUser(String[] lists){
        System.out.println("重复"+lists);
        return  userService.deleteArrayUser(lists);
    }
}