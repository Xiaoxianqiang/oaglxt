package com.fjtons.oaglxt.pojo;

import lombok.Data;

/**
 * 基本项目信息表
 */
@Data
public class BasicProject {
private  String serialNumber;//序号
private  String projectName;//项目名称
private  String projectType;//项目类型  多选设置  逗号分开：1.工程项目 2.技术咨询项目 3.检测技术项目 4.政府采购项目 5.企业环保管家项目 6.其他项目
private  String grossAmount;//工程总金额
private  String receiptsAmount;//实收金额   不太需要
private  String rebateAmount;//返佣金额     不太需要
private  String projectProgress;//项目进度   不太需要   创建时直接未开展
private  String projectSource;//业务来源（项目来源）
private  String principal;//主要负责人
private  String startTime;//开始时间
private  String finishTime;//结束时间
private  String projectProcessingType;//项目处理类型  多选设置
private  String additionalService;//附加业务  不太需要
private  String projectDetails;//项目明细   不太需要
private  String existingProblem;//存在问题  不太需要
private  String province;//请选择省
private  String city;//请选择市
private  String area;//请选择县/区
private  String ownerName;//业主名称
private  String collectionRatio;//收款比例  不太需要
private  String uncollectedProportion;//未收比例  不太需要
private  String invoiceAmount;//开票金额   不太需要
private  String aStateOf;//签订状态 是否签订
private  String  whetherOutsourcing;//whether outsourcing 是否外包
private  String  examination;    //1为审批0为未审批
    //项目发起人    userId    非超级管理员设置的，需要普通用户是判断权限  用户权限  1.超级管理 2.负责人 3.普通用户
    //普通用户看自己的参与的项目与自己参加的项目
    //负责人审批自己部门下面的项目

}
