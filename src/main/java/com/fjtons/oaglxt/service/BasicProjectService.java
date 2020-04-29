package com.fjtons.oaglxt.service;

import com.fjtons.oaglxt.pojo.BasicProject;
import com.fjtons.oaglxt.pojo.PageRequest;
import com.fjtons.oaglxt.pojo.PageResult;

import java.util.List;

public interface BasicProjectService {
    /**
     * 查修所有
     */
    List<BasicProject> selectAll(BasicProject basicProject);

    /**
     * 分页查修接口
     * @return
     */
    PageResult selectPage(PageRequest pageRequest,BasicProject basicProject);
    //批量删除
    int deletBasucByserialNumber(String[] list);
    //单条删除
    int deletOneBasicProject(String str);

    /**
     * 添加信息
     * @param basicProject
     * @return
     */
    int insertBasucByserialNumber(BasicProject basicProject);

    /**
     * 项目审批
     * @param basicProject
     * @return
     */
    int examinationProject(BasicProject basicProject);
    /**
     * 修改信息
     */
    int updateBasucByserialNumber(BasicProject basicProject);
}
