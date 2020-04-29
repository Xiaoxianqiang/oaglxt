/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: department
 * Author:   abc
 * Date:     2020/4/8 15:56
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.fjtons.oaglxt.pojo;

import lombok.Data;

/**
 * 〈部门〉<br>
 * 〈〉
 *
 * @author abc
 * @create 2020/4/8
 * @since 1.0.0
 */
@Data
public class Department {
private String  departmentId;//部门id
    private String  departmentLevel;//部门等级 3级部门 level
    private String  departmentName;//部门名字 name
    private String  departmentHead;//部门负责人   head
    private String  departmentSuperiorId;//上级部门id  superiorId
}