package com.fjtons.oaglxt.mapper;

import com.fjtons.oaglxt.pojo.Department;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface DepartmentMapper {
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
    List<Department>    selBydepartmentId(String departmentId);

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
