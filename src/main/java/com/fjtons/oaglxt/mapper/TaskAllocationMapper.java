package com.fjtons.oaglxt.mapper;

import com.fjtons.oaglxt.pojo.TaskAllocation;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TaskAllocationMapper {
    //selectPage
    List<TaskAllocation>  selectPage(TaskAllocation taskAllocation);
    //deleteTaskAllocationId
    int deleteTaskAllocationId(String[] array);
    //updateTaskAllocation
    int updateTaskAllocation(TaskAllocation taskAllocation);
    //insertTaskAllocation
    int insertTaskAllocation(TaskAllocation taskAllocation);
}
