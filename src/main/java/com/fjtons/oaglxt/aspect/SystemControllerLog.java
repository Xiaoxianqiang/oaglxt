package com.fjtons.oaglxt.aspect;

import java.lang.annotation.*;

/**
 *自定义注解 拦截Controller
 */

@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SystemControllerLog {
    /**
     * 操作说明
     */
    String operteContent() default "";
}
