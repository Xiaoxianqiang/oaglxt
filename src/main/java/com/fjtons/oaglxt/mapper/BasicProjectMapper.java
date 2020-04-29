package com.fjtons.oaglxt.mapper;

import com.fjtons.oaglxt.pojo.BasicProject;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 项目基本信息
 */
@Mapper
public interface BasicProjectMapper{
/**
 * 查询
  */
/**
 * 查修所有
 */
List<BasicProject> selectAll();

/**
 * 分页查修
 * @return
 */
List<BasicProject> selectPage(BasicProject basicProject);
/**
 * 删除
 */
    /**
     * 利用序号删除
     * @param serialNumber
     * @return
     */
    int deletBasucByserialNumber(String serialNumber);
/**
 * 修改
 */
    /**
     * 利用序号修改信息
     * @param basicProject
     * @return
     */
    int updateBasucByserialNumber(BasicProject basicProject);
/**
 * 添加
 */
    /**
     * 添加信息
     * @param basicProject
     * @return
     */
    int insertBasucByserialNumber(BasicProject basicProject);
}
