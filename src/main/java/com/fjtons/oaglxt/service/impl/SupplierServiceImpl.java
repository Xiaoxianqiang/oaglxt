/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: SupplierServiceImpl
 * Author:   abc
 * Date:     2020/4/14 15:34
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.fjtons.oaglxt.service.impl;

import com.fjtons.oaglxt.mapper.SupplierMapper;
import com.fjtons.oaglxt.pojo.PageRequest;
import com.fjtons.oaglxt.pojo.PageResult;
import com.fjtons.oaglxt.pojo.Supplier;
import com.fjtons.oaglxt.service.SupplierService;
import com.fjtons.oaglxt.utils.DataUtil;
import com.fjtons.oaglxt.utils.PageUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author abc
 * @create 2020/4/14
 * @since 1.0.0
 */
@Service
public class SupplierServiceImpl implements SupplierService {
    @Autowired
    private SupplierMapper supplierMapper;


    @Override
    public PageResult selectPage(PageRequest pageRequest, Supplier supplier) {
        return PageUtils.getPageResult(pageRequest, getPageInfo(pageRequest,supplier));
    }

    @Override
    public int deleteSupplierId(String[] array) {
        return supplierMapper.deleteSupplierId(array);
    }

    @Override
    public int insertSupplier(Supplier supplier) {
        supplier.setSupplierId(DataUtil.getTimeUUID());
        return supplierMapper.insertSupplier(supplier);
    }

    @Override
    public int updateSupplier(Supplier supplier) {
        return supplierMapper.updateSupplier(supplier);
    }


    /**
     * 调用分页插件完成分页
     * @param
     * @return
     */
    private PageInfo<Supplier> getPageInfo(PageRequest pageRequest, Supplier supplier) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<Supplier> sysMenus = supplierMapper.selectPage(supplier);//设置关键词查询
        return new PageInfo<Supplier>(sysMenus);
    }
}