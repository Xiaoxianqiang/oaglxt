/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: SupplierController
 * Author:   abc
 * Date:     2020/4/14 15:38
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.fjtons.oaglxt.controller;

import com.fjtons.oaglxt.pojo.PageRequest;
import com.fjtons.oaglxt.pojo.Supplier;
import com.fjtons.oaglxt.service.SupplierService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author abc
 * @create 2020/4/14
 * @since 1.0.0
 */
@Controller
@RequestMapping("/Supplier")
public class SupplierController {
    @Resource
    private SupplierService supplierService;

    /**
     * 获取分页
     * @param  page, limit
     * @return
     * page=1&limit=10
     */
    @RequestMapping(value="/selectPage")
    @ResponseBody
    public Object selectPage(int page, int limit, Supplier supplier) {
        //需要判断自己得权限
        PageRequest pageQuery=new PageRequest();
        pageQuery.setPageNum(page);
        pageQuery.setPageSize(limit);
        return supplierService.selectPage(pageQuery,supplier);
    }
    /**
     * 删除
     */
    @RequestMapping("/deleteSupplierId")
    @ResponseBody
    public  Object deleteSupplierId(String[] lists){
        return  supplierService.deleteSupplierId(lists);
    }
    /**
     * 插入
     */
    @RequestMapping("/insertSupplier")
    @ResponseBody
    public  Object insertSupplier(Supplier supplier){
        return  supplierService.insertSupplier(supplier);
    }
    /**
     * 修改
     */
    @RequestMapping("/updateSupplier")
    @ResponseBody
    public  Object updateSupplier(Supplier supplier){
        return  supplierService.updateSupplier(supplier);
    }
}