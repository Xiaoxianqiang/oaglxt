package com.fjtons.oaglxt.service;

import com.fjtons.oaglxt.pojo.BasicProject;
import com.fjtons.oaglxt.pojo.OutsourcingProject;
import com.fjtons.oaglxt.pojo.PageRequest;
import com.fjtons.oaglxt.pojo.PageResult;

public interface EpiboloyProjectService {
    /**
     * 分页查修接口
     * @return
     */
    PageResult selectPage(PageRequest pageRequest, BasicProject basicProject);

    /**
     * 插入
     */
    int insetByOutsourcingProject(OutsourcingProject outsourcingProject);
    /**
     * 修改
     */
    int updataByOutsourcingProject(OutsourcingProject outsourcingProject);
    /**
     * 删除
     */
    int deletBySerialNumber(String serialNumber);

    int deletBySerialNumberList(String[] serialNumber);
}
