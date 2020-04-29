package com.fjtons.oaglxt.aspect;


import com.fjtons.oaglxt.pojo.AdminLog;
import com.fjtons.oaglxt.pojo.User;

import com.fjtons.oaglxt.service.AdminLogService;
import com.fjtons.oaglxt.utils.DataUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

@Aspect
@Component
public class SystemLogAspect {

    private static final Logger logger = LoggerFactory.getLogger(SystemLogAspect.class);
    @Resource
    private AdminLogService adminLogService;

    /**
     * 切入点
     */
    @Pointcut("@annotation(SystemControllerLog)")
    public void controllerAspect() {
    }
    @Pointcut("@annotation(logout)")
    public void logout(){
    }
    @Pointcut("@annotation(login)")
    public void login(){
    }

    /**
     * 方法调用后触发 , 记录正常操作
     *
     * @param joinPoint
     * @throws ClassNotFoundException
     */
    @AfterReturning("controllerAspect()")
    public void afterRetruning(JoinPoint joinPoint) throws ClassNotFoundException {
        HttpServletRequest req = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        // 获取session
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("loginUser");
        System.out.println("调用方法了"+joinPoint);
        if(user==null){
            return;
        }
        AdminLog adminLog=new AdminLog();
        adminLog.setAdminlogid(DataUtil.getTimeUUID());//时间戳
        adminLog.setAccount(  user.getAccount());//账号
        adminLog.setName(user.getName());//名字
        adminLog.setDate(DataUtil.getNowDate());
        adminLog.setIp(req.getRemoteAddr());//IP
        req.getRemoteAddr();
        String targetName = joinPoint.getTarget().getClass().getName();
        adminLog.setMethodName(targetName);//操作方法
        String methodName = joinPoint.getSignature().getName();
        String description = "";
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                Class[] clazzs = method.getParameterTypes();
                // 操作说明
                if (clazzs.length == arguments.length) {
                    description = method.getAnnotation(SystemControllerLog.class).operteContent();
                    break;
                }
            }
        }
        adminLog.setDescription(description);
        adminLogService.insertAdminLog(adminLog);
        System.out.println("结束");
    }

    /**
     * 发生异常，走此方法
     *
     * @param joinPoint
     * @param e
     */
    @AfterThrowing(pointcut = "controllerAspect()", throwing = "e")
    public void AfterThrowing(JoinPoint joinPoint, Throwable e) {
//
//        HttpServletRequest req = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//        // 获取session
//        HttpSession session = req.getSession();
//        User user = (User) session.getAttribute("loginUser");
//
//        try {
//            //日志id
//            String logId=String.valueOf(new Date().getTime());
//            // 用户id
//            String uid = user.getUid();
//            // 用户名
//            String uname = user.getUname();
//            // 用户IP
//            String ip = req.getRemoteAddr();
//            //获取描述信息
//            SystemLog systemLog=getMethodDesc(joinPoint);
//            // 操作说明
//            String exMsg = e.getCause().toString();
//            if (exMsg != null&&exMsg!="") {
//                String type = "异常";
//                systemLog.setLogId(logId);
//                systemLog.setUid(uid);
//                systemLog.setUname(uname);
//                systemLog.setIp(ip);
//                systemLog.setType(type);
//                systemLog.setExMessage(exMsg);
//                systemLog.setCreateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
//                systemLogService.insertSystemLog(systemLog);
//            }
//        } catch (Exception e1) {
//            logger.error(e1.getMessage());
//        }
    }

    /**
     * 登录后置通知
     * @param joinPoint
     * @throws ClassNotFoundException
     */
    @After("login()")
    public void after(JoinPoint joinPoint) throws ClassNotFoundException {
        HttpServletRequest req = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        /*获取session*/
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("loginUser");
        if(user==null){
            return;
        }
       // System.out.println("我登陆了");
        AdminLog adminLog=new AdminLog();
        adminLog.setAdminlogid(DataUtil.getTimeUUID());//时间戳
        adminLog.setAccount(  user.getAccount());//账号
        adminLog.setName(user.getName());//名字
       adminLog.setDate(DataUtil.getNowDate());
       adminLog.setIp(req.getRemoteAddr());//IP
        req.getRemoteAddr();
                String targetName = joinPoint.getTarget().getClass().getName();
        adminLog.setMethodName(targetName);//操作方法
        String methodName = joinPoint.getSignature().getName();
                Object[] arguments = joinPoint.getArgs();
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        String description = "";
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                Class[] clazzs = method.getParameterTypes();
                // 操作说明
                if (clazzs.length == arguments.length) {
                    description = method.getAnnotation(login.class).operteContent();
                    break;
                }
            }
        }
        adminLog.setDescription(description);
        System.out.println("信息"+description);
        adminLogService.insertAdminLog(adminLog);
        System.out.println("结束");
    }

    /**
     * 注销时记录日志
     * @param joinPoint
     * @throws ClassNotFoundException
     */
    @Before("logout()")
    public void before(JoinPoint joinPoint) throws ClassNotFoundException {
        HttpServletRequest req = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        /*获取session*/
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("loginUser");
        // System.out.println("我登陆了");
        if(user==null){
            return;
        }
        AdminLog adminLog=new AdminLog();
        adminLog.setAdminlogid(DataUtil.getTimeUUID());//时间戳
        adminLog.setAccount(  user.getAccount());//账号
        adminLog.setName(user.getName());//名字
        adminLog.setDate(DataUtil.getNowDate());
        adminLog.setIp(req.getRemoteAddr());//IP
        req.getRemoteAddr();
        String targetName = joinPoint.getTarget().getClass().getName();
        adminLog.setMethodName(targetName);//操作方法
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        String description = "";

        adminLog.setDescription("退出登录");
        System.out.println("信息"+description);
        adminLogService.insertAdminLog(adminLog);
    }
//
//    /**
//     * 得到用户信息
//     *
//     * @return
//     */
//    public static User getUSerMsg() {
//        HttpServletRequest req = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//        // 获取session
//        HttpSession session = req.getSession();
//        User user = (User) session.getAttribute("loginUser");
//
//        return user;
//    }

}