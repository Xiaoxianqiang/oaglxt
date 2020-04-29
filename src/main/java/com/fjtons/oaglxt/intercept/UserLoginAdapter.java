/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: UserLoginAdapter
 * Author:   abc
 * Date:     2020/4/10 14:32
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.fjtons.oaglxt.intercept;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author abc
 * @create 2020/4/10
 * @since 1.0.0
 */
@SpringBootConfiguration
@EnableCaching
public class UserLoginAdapter implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        InterceptorRegistration ir=registry.addInterceptor(new UserLoginInterceptor());
        ir.addPathPatterns("/**");
        ir.excludePathPatterns("/","/login","/js/**","/html/**","/images/**","/css/**","/loginVerify","/lib/**");
    }


}