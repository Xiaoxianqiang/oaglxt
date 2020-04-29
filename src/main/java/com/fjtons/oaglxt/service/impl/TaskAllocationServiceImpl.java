/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: TaskAllocationServiceImpl
 * Author:   abc
 * Date:     2020/4/16 17:03
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.fjtons.oaglxt.service.impl;

import com.fjtons.oaglxt.mapper.TaskAllocationMapper;
import com.fjtons.oaglxt.pojo.PageRequest;
import com.fjtons.oaglxt.pojo.PageResult;
import com.fjtons.oaglxt.pojo.TaskAllocation;
import com.fjtons.oaglxt.service.TaskAllocationService;
import com.fjtons.oaglxt.utils.DataUtil;
import com.fjtons.oaglxt.utils.PageUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author abc
 * @create 2020/4/16
 * @since 1.0.0
 */
@Service
public class TaskAllocationServiceImpl implements TaskAllocationService {
    @Autowired
    private TaskAllocationMapper taskAllocationMapper;





    @Override
    public PageResult selectPage(PageRequest pageRequest, TaskAllocation taskAllocation) {
        return  PageUtils.getPageResult(pageRequest, getPageInfo(pageRequest,taskAllocation));
    }

    @Override
    public int deleteTaskAllocationId(String[] array) {
        return taskAllocationMapper.deleteTaskAllocationId(array);
    }

    @Override
    public int updateTaskAllocation(TaskAllocation taskAllocation) {
        return taskAllocationMapper.updateTaskAllocation(taskAllocation);
    }

    @Override
    public int insertTaskAllocation(TaskAllocation taskAllocation) {
        taskAllocation.setTaskAllocationId(DataUtil.getTimeUUID());
        return taskAllocationMapper.insertTaskAllocation(taskAllocation);
    }


    /**
     * 调用分页插件完成分页
     * @param
     * @return
     */
    private PageInfo<TaskAllocation> getPageInfo(PageRequest pageRequest, TaskAllocation taskAllocation) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<TaskAllocation> sysMenus = taskAllocationMapper.selectPage(taskAllocation);//设置关键词查询
        return new PageInfo<TaskAllocation>(sysMenus);
    }
}