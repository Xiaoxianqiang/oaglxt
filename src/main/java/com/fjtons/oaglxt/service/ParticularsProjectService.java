package com.fjtons.oaglxt.service;

import com.fjtons.oaglxt.pojo.PageRequest;
import com.fjtons.oaglxt.pojo.PageResult;
import com.fjtons.oaglxt.pojo.SignedProject;

import java.util.List;

public interface ParticularsProjectService {
    /**
     * 分页查修接口
     * @return
     */
    PageResult selectPage(PageRequest pageRequest, SignedProject signedProject);
    /**
     * 分页查询  对接项目  project_progress="未开展"
     */
    PageResult selAllDocking(PageRequest pageRequest ,SignedProject signedProject);
    /**
     * 分页查询  未对接项目  project_progress="未开展"
     */
    PageResult selAllNotDocking(PageRequest pageRequest ,SignedProject signedProject);
    /**
     * 分页查询   落地项目
     */
    PageResult selAllLanding(PageRequest pageRequest ,SignedProject signedProject);
    /**
     * 分页查询   完成项目
     */
    PageResult selAllComplete(PageRequest pageRequest ,SignedProject signedProject);
    /**
     * 分页查询   终止项目
     */
    PageResult selAllTermination(PageRequest pageRequest ,SignedProject signedProject);

    /**
     * 添加信息
     * @param signedProject
     * @return
     */
    int insetBySignedProject(SignedProject signedProject);
    /**
     * 修改
     */
    int updataSignedProject(SignedProject signedProject);

    /**
     * 删除
     */
    int   deleteSignedProject(String serialNumber);
    /**
     * 批量删除
     */
    int   deleteSignedProjectList(String[] serialNumber);
}
