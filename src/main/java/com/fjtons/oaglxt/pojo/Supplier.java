/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: Supplier
 * Author:   abc
 * Date:     2020/4/14 14:57
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.fjtons.oaglxt.pojo;

import lombok.Data;

/**
 * 〈供应商〉<br>
 * 〈〉
 *
 * @author abc
 * @create 2020/4/14
 * @since 1.0.0
 */
@Data
public class Supplier {
  private  String supplierId;//供应商编号 时间戳
  private  String supplierName;//供应商名称
    private  String supplierCompany;//归属公司
    private  String  projectId;//项目编号
    private  String  supplierMaterialName;//物料名称
    private  String  supplierAfterSales;//售后
    private  String  supplierType;//所属类别
    private  String  supplierContact;//联系人
    private  String  supplierContactPhone;//联系电话
   //supplier  contact
  //归属公司，项目编号，供应商编号（id），供应商名称，物料名称，设备售后维保情况，所属类别，联系人，联系电话

}