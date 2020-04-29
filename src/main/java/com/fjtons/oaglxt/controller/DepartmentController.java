/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: DepartmentController
 * Author:   abc
 * Date:     2020/4/9 15:22
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.fjtons.oaglxt.controller;

import com.fjtons.oaglxt.pojo.Department;
import com.fjtons.oaglxt.service.DepartmentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author abc
 * @create 2020/4/9
 * @since 1.0.0
 */
@Controller
@RequestMapping("/Department")
public class DepartmentController {
    @Resource
    DepartmentService departmentService;

    @RequestMapping(value="/selectPage")
    @ResponseBody
    public Object selectPage(Department department) {
        return departmentService.selectPage(department);
    }
    //queryBydepartmentId
    @RequestMapping(value="/queryBydepartmentId")
    @ResponseBody
    public Object queryBydepartmentId(String department) {
        return departmentService.queryBydepartmentId(department);
    }
    //selBydepartmentId
    @RequestMapping(value="/selBydepartmentId")
    @ResponseBody
    public Object selBydepartmentId(String department) {
        return departmentService.selBydepartmentId(department);
    }
   // updateDepartment
   @RequestMapping(value="/updateDepartment")
   @ResponseBody
   public Object updateDepartment(Department department) {
       return departmentService.updateDepartment(department);
   }
   //insertDepartment
   @RequestMapping(value="/insertDepartment")
   @ResponseBody
   public Object insertDepartment(Department department) {
       department.setDepartmentLevel("1");
       department.setDepartmentSuperiorId("0");
       return departmentService.insertDepartment(department);
   }
    @RequestMapping(value="/insertDepartment2")
    @ResponseBody
    public Object insertDepartment2(Department department) {
        return departmentService.insertDepartment(department);
    }
    //deleteArrayDepartment
    @RequestMapping("deleteArrayDepartment")
    @ResponseBody
    public  Object deleteArrayDepartment(String[] lists){
        System.out.println("重复"+lists);
        return  departmentService.deleteArrayDepartment(lists);
    }
    //sellDepartment
    @RequestMapping("sellDepartment")
    @ResponseBody
    public  Object sellDepartment(Department department){
        return  departmentService.sellDepartment(department);
    }
}