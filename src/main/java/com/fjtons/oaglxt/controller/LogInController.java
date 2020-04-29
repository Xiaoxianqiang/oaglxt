/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: logInController
 * Author:   abc
 * Date:     2020/2/12 16:03
 * Description: logInController
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.fjtons.oaglxt.controller;

import com.fjtons.oaglxt.aspect.login;
import com.fjtons.oaglxt.aspect.logout;
import com.fjtons.oaglxt.pojo.User;
import com.fjtons.oaglxt.service.UserService;
import com.fjtons.oaglxt.utils.MD5Util;
import com.fjtons.oaglxt.utils.VerifyUtil;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;


/**
 * 〈登录控制类〉<br>
 * 〈logInController〉
 *
 * @author abc
 * @create 2020/2/12
 * @since 1.0.0
 */
@Controller
public class LogInController {
    @Resource
    UserService userService;
    /**
     * 跳转到登录页
     * @return
     */
    @RequestMapping({"/"})
    public String enterLogin() {
        return "logins/login";
    }
    /**
     *  跳转到首页
     * @return
     */
    @RequestMapping(value = "/index")
    public  String index(){
        return "index";
    }

    /**
     * 项目分类开始
     * @return
     */
    //basicproject-list
    //跳转到工程汇总页面
    @RequestMapping(value = "/basicproject")
    public String basicproject(){
        return "basicprojectList/basicproject-list";
    }
    //notDockingProjiect_list.html
    //跳转到未对接项目界面
    @RequestMapping(value = "/notDockingProjiect")
    public String notDockingProjiect(){
        return  "projectClassification/notDockingProjiect_list";
    }
    //跳到对接项目界面    dockingProject_list.html
    @RequestMapping(value = "/dockingProject")
    public String dockingProject(){
        return  "projectClassification/dockingProject_list";
    }
    //跳到落地项目界面  landingProject
    @RequestMapping(value = "/landingProject")
    public String landingProject(){
        return  "projectClassification/landingProject_list";
    }
    //跳到完成项目界面  completeProject
    @RequestMapping(value = "/completeProject")
    public String completeProject(){
        return  "projectClassification/completeProject_list";
    }
    //跳到终止项目界面  terminationProject
    @RequestMapping(value = "/terminationProject")
    public String terminationProject(){
        return  "projectClassification/terminationProject_list";
    }
    /**
     * 项目分类结束
     * @return
     */
    /**
     * 用户管理
     */
    @RequestMapping(value = "/userControl")
    public String userControl(){
        return  "User/userControl-list";
    }
    /**
     *部门管理
     */
    @RequestMapping(value = "/AdminLog")
    public String AdminLog(){
        return  "AdminLog/AdminLoglist";
    }
    /**
     *部门管理
     */
    @RequestMapping(value = "/Department")
    public String Department(){
        return  "Department/DepartmentList";
    }

    /**
     * 项目汇总开始
     * @return
     */
    //跳转到签订项目界面 signedList signedproject-list.html
    @RequestMapping(value = "/signedProject")
    public String signedProject(){
        return  "signedList/signedproject-list";
    }
    //跳转到未签订项目 signedList notSignedproject-list.html
    @RequestMapping(value = "/notSignedproject")
    public String notSignedproject(){
        return  "signedList/notSignedproject-list";
    }
    //外包项目  signedList outsourcingProject_list.html
    @RequestMapping(value = "/outsourcingProjec")
    public String outsourcingProjec(){
        return  "signedList/OutsourcingProject_list";
    }
    //外包项目  signedList outsourcingProject_list.html
    @RequestMapping(value = "/examination")
    public String examination(){
        return  "examination/ExaminationList";
    }

    /**
     * 项目汇总结束
     */

    /**
     *  获取个人信息
     */
    @RequestMapping(value = "/personalInformation")
    @ResponseBody
    public Map loginUser(HttpSession session){
        Map<String,Object> map=new HashMap();
        map.put("loginUser",session.getAttribute("loginUser"));
        return  map;
    }


    /**
     * 登录验证
     * @param userLogin
     * @param session
     * @return
     */
    @login(operteContent = "登录验证")
    @RequestMapping("/login")
    @ResponseBody
    public Map login(@RequestBody User userLogin, HttpSession session){
        Map<String, Object> map = new HashMap();
      //  System.out.println("数据"+userLogin.getCanvas());
        if(!userLogin.getCanvas().equalsIgnoreCase(session.getAttribute("RANDOMVALIDATECODEKEY").toString())){
            map.put("status","验证码错误");
        }else {
            User user=null;
            //先判断手机，在判断自己的账号
            if(userLogin.getAccount().length()>=11){
                user=userService.queryUserByPhone(userLogin.getAccount());
            }else {
                user=userService.queryUserByAccount(userLogin.getAccount());
            }
            if(user==null){
                map.put("status","账户不存在");
            }else {
                if(MD5Util.string2MD5(userLogin.getPassword()).equals(user.getPassword())){//密码正确登录成功
                    session.setAttribute("loginUser", user);//存入session
                    //跳转进入首页
                    map.put("status","登录成功");
                }else {
                    map.put("status","密码错误");
                }
            }
        }
        return  map;
    }

    /**
     * 退出登录
     * @return
     */
    @logout(operteContent = "退出验证")
    @RequestMapping({"/quit"})
    public  String quit(HttpSession session){
        session.removeAttribute("loginUser");//删除session
        return "logins/login";
    }
//information

    /**
     * 生成验证码
     *
     * @param request
     * @param response
     */
    @RequestMapping(value = "/loginVerify", method = RequestMethod.GET)
    @ResponseBody
    public void Verify(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("image/jpeg");//设置相应类型,告诉浏览器输出的内容为图片
        response.setHeader("Pragma", "No-cache");//设置响应头信息，告诉浏览器不要缓存此内容
        //做浏览器兼容
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expire", 0);
        VerifyUtil randomValidateCode = new VerifyUtil();
        try {
            randomValidateCode.getRandcode(request, response);//输出图片方法
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}