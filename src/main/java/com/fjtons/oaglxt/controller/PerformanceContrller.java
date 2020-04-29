/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: PerformanceContrller
 * Author:   abc
 * Date:     2020/4/17 16:56
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.fjtons.oaglxt.controller;

import com.fjtons.oaglxt.pojo.PageRequest;
import com.fjtons.oaglxt.pojo.Performance;
import com.fjtons.oaglxt.service.PerformanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author abc
 * @create 2020/4/17
 * @since 1.0.0
 */
@Controller
@RequestMapping("/Performance")
public class PerformanceContrller {
    @Autowired
    private PerformanceService performanceService;

    /**
     * 获取分页
     * @param  page, limit
     * @return
     * page=1&limit=10
     */
    @RequestMapping(value="/selectPage")
    @ResponseBody
    public Object selectPage(int page, int limit, Performance performance) {
        //需要判断自己得权限
        PageRequest pageQuery=new PageRequest();
        pageQuery.setPageNum(page);
        pageQuery.setPageSize(limit);
        return performanceService.selectPage(pageQuery,performance);
    }
    /**
     * 删除
     */
    @RequestMapping("/deletePerformanceId")
    @ResponseBody
    public  Object deleteTaskAllocationId(String[] lists){
        return  performanceService.deletePerformanceId(lists);
    }
    /**
     * 插入
     */
    @RequestMapping("/insertPerformance")
    @ResponseBody
    public  Object insertPerformance(Performance performance){
        return  performanceService.insertPerformance(performance);
    }
    /**
     * 修改
     */
    @RequestMapping("/updatePerformance")
    @ResponseBody
    public  Object updatePerformance(Performance performance) {
        return performanceService.updatePerformance(performance);
    }
}