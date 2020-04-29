/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: UserServiceImpl
 * Author:   abc
 * Date:     2020/2/12 16:20
 * Description: UserServiceImpl
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.fjtons.oaglxt.service.impl;

import com.fjtons.oaglxt.mapper.UserMapper;
import com.fjtons.oaglxt.pojo.BasicProject;
import com.fjtons.oaglxt.pojo.PageRequest;
import com.fjtons.oaglxt.pojo.PageResult;
import com.fjtons.oaglxt.pojo.User;
import com.fjtons.oaglxt.service.UserService;
import com.fjtons.oaglxt.utils.DataUtil;
import com.fjtons.oaglxt.utils.MD5Util;
import com.fjtons.oaglxt.utils.PageUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈UserServiceImpl〉
 *
 * @author abc
 * @create 2020/2/12
 * @since 1.0.0
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;


    @Override
    public User queryUserByAccount(String account) {
        return userMapper.queryUserByAccount(account);
    }


    /**
     * 分页查修
     * @return
     */
    @Override
    public PageResult selectPage(PageRequest pageRequest, User user) {
        return PageUtils.getPageResult(pageRequest, getPageInfo(pageRequest,user));
    }

    @Override
    public User queryUserByPhone(String phone) {
        return userMapper.queryUserByPhone(phone);
    }

    @Override
    public int insertUser(User user) {
        //判断是否重复 重复就不能添加
        User newUser=new User();
        newUser.setAccount(user.getAccount());
        List<User> users=userMapper.selAllUser(newUser);
        if( users.size()>0){

            return  4;
        }else {
            user.setRegtime(DataUtil.getNowDate());
            //密码默认为123456
            user.setPassword(MD5Util.string2MD5("123456"));
            return userMapper.insertUser(user);
        }
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public int deleteArrayUser(String[] array) {
        System.out.println("重复"+array);
        return userMapper.deleteArrayUser(array);
    }


    @Override
    public int replacePassword(String oldpass, String pass) {
        HttpServletRequest req = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        // 获取session
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("loginUser");
        //比较旧密码是否正确，正确在替换新密码
        if(MD5Util.string2MD5(oldpass).equals(user.getPassword())){
            //创建一个新的user用户
            User newUser=new User();
            newUser.setAccount(user.getAccount());
            newUser.setPassword(MD5Util.string2MD5(pass));
            newUser.setRegtime(DataUtil.getFomatTime(new Date()));
            return  userMapper.updateUser(newUser);
        }else {
            return  99;//旧密码错误
        }

    }

    @Override
    public List<User> queryUserResponsible() {
        return userMapper.queryUserResponsible();
    }


    /**
     * 调用分页插件完成分页
     * @param
     * @return
     */
    private PageInfo<User> getPageInfo(PageRequest pageRequest, User user) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<User> sysMenus = userMapper.selAllUser(user);//设置关键词查询
        return new PageInfo<User>(sysMenus);
    }
}