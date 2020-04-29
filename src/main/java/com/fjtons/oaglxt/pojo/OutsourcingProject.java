package com.fjtons.oaglxt.pojo;

import lombok.Data;

/**
 * 外包项目表
 */
@Data
public class OutsourcingProject {//OutsourcingProject_list
    private  String serialNumber;//序号
    private  String projectName;//项目名称
    private  String industryType;//行业类型  industry_type
    private  String outsourcingUnit;//外包单位 outsourcing_unit
    private  String epibolyMoney;//外包金额 epiboly_money
    private  String grossAmount;//工程总金额
    private  String projectBalance;//差额  project_balance
    private  String advance;//预付款 advance
    private  String arrivalMoney; //到货款 arrival_money
    private  String installMoney;//安装款 install_money
    private  String acceptMoney; //验收款 accept_money
    private  String cashDeposit; //保证金 cash_deposit
    private  String businessExpense; //业务支出 business_expense
    private  String selfControl; //自控（人名）  self_control
    private  String technology;//工艺（人名） technology
    private  BasicProject basicProject;
}
