/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: UserLoginAdapter
 * Author:   abc
 * Date:     2020/4/10 14:27
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.fjtons.oaglxt.intercept;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 〈拦截未登录〉<br>
 * 〈〉
 *
 * @author abc
 * @create 2020/4/10
 * @since 1.0.0
 */
@Component
public class UserLoginInterceptor implements HandlerInterceptor  {
    //    在请求处理之前调用,只有返回true才会执行请求
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
//        得到session
        HttpSession session = httpServletRequest.getSession(true);
//        得到对象
        Object admin = session.getAttribute("loginUser");
        if(admin!=null){
            return true;
        }else{
//            不存在则跳转到登录页
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath()+"/");
            return false;
        }
    }

    //    试图渲染之后执行
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    //    在请求处理之后,视图渲染之前执行
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }


}