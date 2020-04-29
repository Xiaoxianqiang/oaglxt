/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: AdminLogController
 * Author:   abc
 * Date:     2020/4/12 10:08
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.fjtons.oaglxt.controller;

import com.fjtons.oaglxt.pojo.AdminLog;
import com.fjtons.oaglxt.pojo.PageRequest;
import com.fjtons.oaglxt.service.AdminLogService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author abc
 * @create 2020/4/12
 * @since 1.0.0
 */
@Controller
@RequestMapping("/Adminlog")
public class AdminLogController {
    @Resource
    private AdminLogService adminLogService;

    /**
     * 分页查询
     * @param page
     * @param limit
     * @param adminLog
     * @return
     */
    @RequestMapping(value="/selectPage")
    @ResponseBody
    public Object selectPage(int page, int limit, AdminLog adminLog) {
        //需要判断自己得权限
        PageRequest pageQuery=new PageRequest();
        pageQuery.setPageNum(page);
        pageQuery.setPageSize(limit);
        return adminLogService.selectPage(pageQuery,adminLog);
    }
    /**
     * 删除
     */
    @RequestMapping("deleteArrayAdminlog")
    @ResponseBody
    public  Object deleteArrayAdminlog(String[] lists){
        System.out.println("重复"+lists[0]);
        return  adminLogService.deleteArrayAdminlog(lists);
    }
    /**
     *
     */
}