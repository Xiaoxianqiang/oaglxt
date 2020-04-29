/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: TaskAllocationController
 * Author:   abc
 * Date:     2020/4/16 17:07
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.fjtons.oaglxt.controller;

import com.fjtons.oaglxt.pojo.PageRequest;
import com.fjtons.oaglxt.pojo.TaskAllocation;
import com.fjtons.oaglxt.service.TaskAllocationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author abc
 * @create 2020/4/16
 * @since 1.0.0
 */
@Controller
@RequestMapping("TaskAllocation")
public class TaskAllocationController {
    @Resource
    private TaskAllocationService taskAllocationService;

    /**
     * 获取分页
     * @param  page, limit
     * @return
     * page=1&limit=10
     */
    @RequestMapping(value="/selectPage")
    @ResponseBody
    public Object selectPage(int page, int limit, TaskAllocation taskAllocation) {
        //需要判断自己得权限
        PageRequest pageQuery=new PageRequest();
        pageQuery.setPageNum(page);
        pageQuery.setPageSize(limit);
        return taskAllocationService.selectPage(pageQuery,taskAllocation);
    }
    /**
     * 删除
     */
    @RequestMapping("/deleteTaskAllocationId")
    @ResponseBody
    public  Object deleteTaskAllocationId(String[] lists){
        return  taskAllocationService.deleteTaskAllocationId(lists);
    }
    /**
     * 插入
     */
    @RequestMapping("/insertTaskAllocation")
    @ResponseBody
    public  Object insertTaskAllocation(TaskAllocation taskAllocation){
        return  taskAllocationService.insertTaskAllocation(taskAllocation);
    }
    /**
     * 修改
     */
    @RequestMapping("/updateTaskAllocation")
    @ResponseBody
    public  Object updateTaskAllocation(TaskAllocation taskAllocation) {
        return taskAllocationService.updateTaskAllocation(taskAllocation);
    }
}