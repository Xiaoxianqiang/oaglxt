/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: Performance
 * Author:   abc
 * Date:     2020/4/17 11:28
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.fjtons.oaglxt.pojo;

import lombok.Data;

/**
 * 〈绩效分配〉<br>
 * 〈〉
 *
 * @author abc
 * @create 2020/4/17
 * @since 1.0.0
 */
@Data
public class Performance {//personnel
 private  String personnelId;   //绩效id
    private  String personnelName;  //分配名称
    private  String personnelProportion;   //分配占比  proportion
    private  String personnelPersonnel;  //人员 personnel
    private  String personnelBusiness;  //是否新产生新的业务 business
    private  String personnelNote;   //备注 note
    private  String projectId;   //项目id

}
//人员
//有无产生新业务
//备注