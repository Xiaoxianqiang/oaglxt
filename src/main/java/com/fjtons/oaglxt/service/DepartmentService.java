package com.fjtons.oaglxt.service;

import com.fjtons.oaglxt.pojo.Department;

import java.util.List;

public interface DepartmentService {
    /**
     * 分页查询
     * @param department
     * @return
     */
    List<Department> selectPage(Department department);
    /**
     * 查看该部门下面是否还有部门
     * @param departmentId
     * @return
     */
    int  selBydepartmentId(String departmentId);

    Department queryBydepartmentId(String departmentId);

    List<Department> sellDepartment(Department department);
    /**
     * 修改
     * @param department
     * @return
     */
    int updateDepartment(Department department);

    /**
     * 添加
     * @param department
     * @return
     */
    int insertDepartment(Department department);

    /**
     * 删除数组
     * @param array
     * @return
     */

    int  deleteArrayDepartment(String[] array);
}
