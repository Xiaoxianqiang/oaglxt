package com.fjtons.oaglxt.service;

import com.fjtons.oaglxt.pojo.PageRequest;
import com.fjtons.oaglxt.pojo.PageResult;
import com.fjtons.oaglxt.pojo.Supplier;

public interface SupplierService {
    /**
     * 分页查修接口
     * @return
     */
    PageResult selectPage(PageRequest pageRequest, Supplier supplier);

    int deleteSupplierId(String[] array);
    int insertSupplier(Supplier supplier);
    int updateSupplier(Supplier supplier);
}
