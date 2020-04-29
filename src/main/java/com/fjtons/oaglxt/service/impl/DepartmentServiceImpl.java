/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: DepartmentServiceImpl
 * Author:   abc
 * Date:     2020/4/9 11:40
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.fjtons.oaglxt.service.impl;

import com.fjtons.oaglxt.mapper.DepartmentMapper;
import com.fjtons.oaglxt.pojo.Department;
import com.fjtons.oaglxt.service.DepartmentService;
import com.fjtons.oaglxt.utils.DataUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author abc
 * @create 2020/4/9
 * @since 1.0.0
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    DepartmentMapper departmentMapper;

    @Override
    public List<Department> selectPage(Department department) {
        return departmentMapper.selectPage(department);
    }

    @Override
    public int selBydepartmentId(String departmentId) {
        return departmentMapper.selBydepartmentId(departmentId).size();
    }

    @Override
    public Department queryBydepartmentId(String departmentId) {
        return departmentMapper.queryBydepartmentId(departmentId);
    }

    @Override
    public List<Department> sellDepartment(Department department) {
        return departmentMapper.sellDepartment(department);
    }

    @Override
    public int updateDepartment(Department department) {
        return departmentMapper.updateDepartment(department);
    }

    @Override
    public int insertDepartment(Department department) {
        System.out.println("部门民资"+department.getDepartmentName());
        department.setDepartmentId(DataUtil.getTimeUUID());

        return departmentMapper.insertDepartment(department);
    }

    @Override
    public int deleteArrayDepartment(String[] array) {
        return departmentMapper.deleteArrayDepartment(array);
    }


}