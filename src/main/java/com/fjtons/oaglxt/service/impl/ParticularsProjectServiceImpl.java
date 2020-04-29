package com.fjtons.oaglxt.service.impl;


import com.fjtons.oaglxt.mapper.BasicProjectMapper;
import com.fjtons.oaglxt.mapper.ParticularsProjectMapper;
import com.fjtons.oaglxt.pojo.PageRequest;
import com.fjtons.oaglxt.pojo.PageResult;
import com.fjtons.oaglxt.pojo.SignedProject;
import com.fjtons.oaglxt.service.ParticularsProjectService;
import com.fjtons.oaglxt.utils.PageUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParticularsProjectServiceImpl implements ParticularsProjectService {
    @Autowired
    ParticularsProjectMapper particularsProjectMapper;
    @Autowired
    BasicProjectMapper basicProjectMapper;

    @Override
    public PageResult selectPage(PageRequest pageRequest, SignedProject signedProject) {
        return PageUtils.getPageResult(pageRequest, getPageInfo(pageRequest,signedProject));//最高权限的分页
    }

    @Override
    public PageResult selAllDocking(PageRequest pageRequest, SignedProject signedProject) {
        return PageUtils.getPageResult(pageRequest, getPageInfoDocking(pageRequest,signedProject));
    }

    @Override
    public PageResult selAllNotDocking(PageRequest pageRequest, SignedProject signedProject) {
        return PageUtils.getPageResult(pageRequest, getPageInfoNotDocking(pageRequest,signedProject));
    }

    @Override
    public PageResult selAllLanding(PageRequest pageRequest, SignedProject signedProject) {
        return PageUtils.getPageResult(pageRequest, getPageInfoLanding(pageRequest,signedProject));
    }

    @Override
    public PageResult selAllComplete(PageRequest pageRequest, SignedProject signedProject) {
        return PageUtils.getPageResult(pageRequest, getPageInfoComplete(pageRequest,signedProject));
    }

    @Override
    public PageResult selAllTermination(PageRequest pageRequest, SignedProject signedProject) {
        return PageUtils.getPageResult(pageRequest, getPageInfoTermination(pageRequest,signedProject));
    }

    @Override
    public int insetBySignedProject(SignedProject signedProject) {
        return particularsProjectMapper.insetBySignedProject(signedProject);
    }

    @Override
    public int updataSignedProject(SignedProject signedProject) {
        return particularsProjectMapper.updataSignedProject(signedProject);
    }

    @Override
    public int deleteSignedProject(String serialNumber) {
        basicProjectMapper.deletBasucByserialNumber(serialNumber);//删除基本信息
        return particularsProjectMapper.deleteSignedProject(serialNumber);
    }

    @Override
    public int deleteSignedProjectList(String[] serialNumber) {
        for (int i = 0; i <serialNumber.length ; i++) {
            basicProjectMapper.deletBasucByserialNumber(serialNumber[i]);
            particularsProjectMapper.deleteSignedProject(serialNumber[i]);
        }
        return 1;
    }


    /**
     * 调用分页插件完成分页
     * @param
     * @return
     */
    private PageInfo<SignedProject> getPageInfo(PageRequest pageRequest,  SignedProject signedProject) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<SignedProject> sysMenus = particularsProjectMapper.selAll(signedProject);//设置关键词查询
        return new PageInfo<SignedProject>(sysMenus);
    }
    /**
     * 调用分页插件完成分页   对接项目
     * @param
     * @return
     */
    private PageInfo<SignedProject> getPageInfoDocking(PageRequest pageRequest,  SignedProject signedProject) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<SignedProject> sysMenus = particularsProjectMapper.selAllNotDocking(signedProject);//设置关键词查询
        return new PageInfo<SignedProject>(sysMenus);
    }
    /**
     * 调用分页插件完成分页   未对接项目
     * @param
     * @return
     */
    private PageInfo<SignedProject> getPageInfoNotDocking(PageRequest pageRequest,  SignedProject signedProject) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<SignedProject> sysMenus = particularsProjectMapper.selAllNotDocking(signedProject);//设置关键词查询
        return new PageInfo<SignedProject>(sysMenus);
    }
    /**
     * 调用分页插件完成分页   落地项目
     * @param
     * @return
     */
    private PageInfo<SignedProject> getPageInfoLanding(PageRequest pageRequest,  SignedProject signedProject) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<SignedProject> sysMenus = particularsProjectMapper.selAllLanding(signedProject);//设置关键词查询
        return new PageInfo<SignedProject>(sysMenus);
    }
    /**
     * 调用分页插件完成分页   完成项目
     * @param
     * @return
     */
    private PageInfo<SignedProject> getPageInfoComplete(PageRequest pageRequest,  SignedProject signedProject) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<SignedProject> sysMenus = particularsProjectMapper.selAllComplete(signedProject);//设置关键词查询
        return new PageInfo<SignedProject>(sysMenus);
    }
    /**
     * 调用分页插件完成分页   终止项目
     * @param
     * @return
     */
    private PageInfo<SignedProject> getPageInfoTermination(PageRequest pageRequest,  SignedProject signedProject) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<SignedProject> sysMenus = particularsProjectMapper.selAllTermination(signedProject);//设置关键词查询
        return new PageInfo<SignedProject>(sysMenus);
    }
}
