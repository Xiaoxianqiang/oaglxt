/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: TaskAllocationService
 * Author:   abc
 * Date:     2020/4/16 17:00
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.fjtons.oaglxt.service;

import com.fjtons.oaglxt.pojo.PageRequest;
import com.fjtons.oaglxt.pojo.PageResult;
import com.fjtons.oaglxt.pojo.TaskAllocation;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author abc
 * @create 2020/4/16
 * @since 1.0.0
 */
public interface TaskAllocationService {



    PageResult selectPage(PageRequest pageRequest, TaskAllocation taskAllocation);


    int deleteTaskAllocationId(String[] array);

    int updateTaskAllocation(TaskAllocation taskAllocation);

    int insertTaskAllocation(TaskAllocation taskAllocation);
}