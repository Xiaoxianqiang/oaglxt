/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: AdminLog
 * Author:   abc
 * Date:     2020/4/8 16:27
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.fjtons.oaglxt.pojo;

import lombok.Data;

/**
 * 〈管理日志〉<br>
 * 〈〉
 *
 * @author abc
 * @create 2020/4/8
 * @since 1.0.0
 */
@Data
public class AdminLog {
 private  String adminlogid;//id
   private  String account; //用户账号
    private  String name;//用户
    private  String date;//日期
    private  String ip;//ip
    private  String description;//操作说明
    private  String methodName;//操作方法
}