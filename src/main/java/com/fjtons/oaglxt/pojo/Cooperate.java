/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: Cooperate
 * Author:   abc
 * Date:     2020/4/14 17:49
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.fjtons.oaglxt.pojo;

import lombok.Data;

/**
 * 〈工程分配〉<br>
 * 〈〉
 *
 * @author abc
 * @create 2020/4/14
 * @since 1.0.0
 */
@Data
public class Cooperate {//cooperate
private  String cooperateId;//工程配合单位编码
private  String cooperateName;//工程配合单位
private  String cooperateCompany;//归属公司
private  String cooperateType;//业务类型
private  String projectId;//项目编号
private  String cooperateCompanyName;//客户名称
//private  String projectname;//工程配合项目名称
//private  String projectProcessingType;//所属类型
private  String cooperateContact;//联系人
private  String cooperateContactPhone;//联系电话
private  String cooperateQuality ;//工程质量
//private  String projectProgress;//项目进度

}