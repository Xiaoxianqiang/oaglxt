package com.fjtons.oaglxt.pojo;

import lombok.Data;

/**
 * 签订信息与未签订信息表
 */
@Data
public class SignedProject {
    //基本信息创建完后，有签订项目时，创建签订信息表，自己过来补充
    private  String serialNumber;//序号
    private  String projectName;//项目名称
    private  String projectContact; //项目联系人（业主名称）  或者另外写,有可能添加电话
    private  String grossAmount;//工程总金额
    private  String advance;//预付款 advance
    private  String arrivalMoney; //到货款 arrival_money
    private  String installMoney;//安装款 install_money
    private  String acceptMoney; //验收款 accept_money
    private  String cashDeposit; //保证金 cash_deposit
    private  String businessExpense; //业务支出 business_expense
    private  String alias;  //供应商或分包单位名称 alias
    private  String flueGas; //废气  人名 flue_gas
    private  String wasteWater; //废水  人名 waste_water
    private  String projectProgress;//项目进度（自己补充）   project_progress
    private  String collectionRatio; //收款比例 collection_ratio
    private  String uncollectedProportion; //未收比例 uncollected_proportion
    private  String invoiceAmount; //开票金额  invoice_amount
    private  String drainCauses;//流失原因
    private String lossOfPhase;//流失阶段
    private  BasicProject basicProject;//获取基本信息的数据
}
