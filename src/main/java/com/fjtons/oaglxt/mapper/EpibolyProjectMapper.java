package com.fjtons.oaglxt.mapper;

import com.fjtons.oaglxt.pojo.BasicProject;
import com.fjtons.oaglxt.pojo.OutsourcingProject;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 外包信息补充包
 */
@Mapper
public interface EpibolyProjectMapper {
    /**
     * 查询
     */
    List<BasicProject> selectPage(BasicProject basicProject);
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

}
