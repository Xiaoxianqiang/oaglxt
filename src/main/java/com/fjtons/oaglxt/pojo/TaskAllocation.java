/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: TaskAllocation
 * Author:   abc
 * Date:     2020/4/16 10:54
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.fjtons.oaglxt.pojo;

import lombok.Data;

/**
 * 〈任务分配〉<br>
 * 〈〉
 *
 * @author abc
 * @create 2020/4/16
 * @since 1.0.0
 */
@Data
public class TaskAllocation {   //task_allocation
  private  String   taskAllocationId;//任务分配编号
    private  String   taskAllocationName; //分配名称
    private  String   taskAllocationOutput; //输出情况  output
    private  String   taskAllocationPersonnel;   //人员  personnel
    private  String   taskAllocationSigned;//是否签订  signed
    private  String   taskAllocationType;  //项目类型  Type
    private  String   taskAllocationNote;  //备注   备注 note
    private  String   projectId;   //项目id
}