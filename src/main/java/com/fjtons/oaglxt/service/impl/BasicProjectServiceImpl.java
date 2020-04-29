package com.fjtons.oaglxt.service.impl;

import com.fjtons.oaglxt.mapper.BasicProjectMapper;
import com.fjtons.oaglxt.mapper.EpibolyProjectMapper;
import com.fjtons.oaglxt.mapper.ParticularsProjectMapper;
import com.fjtons.oaglxt.pojo.*;
import com.fjtons.oaglxt.service.BasicProjectService;
import com.fjtons.oaglxt.utils.DataUtil;
import com.fjtons.oaglxt.utils.PageUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BasicProjectServiceImpl implements BasicProjectService {
    @Autowired
    BasicProjectMapper basicProjectMapper;
    @Autowired
    ParticularsProjectMapper particularsProjectMapper;//信息补充
    @Autowired
    EpibolyProjectMapper epibolyProjectMapper;//外包

    /**
     * 查修全部
     * @return
     */
    public List<BasicProject> selectAll(BasicProject basicProject) {
        basicProject.setExamination("1");
        return basicProjectMapper.selectPage(basicProject);
    }


    /**
     * 利用序号删除
     * @param list
     * @return
     */
    @Override
    public int  deletBasucByserialNumber(String[] list) {
        for (int i=0;i<list.length;i++){
            basicProjectMapper.deletBasucByserialNumber(list[i]);
        }
        return 1;
    }

    @Override
    public int deletOneBasicProject(String str) {
        return  basicProjectMapper.deletBasucByserialNumber(str);
    }

    @Override
    public int insertBasucByserialNumber(BasicProject basicProject) {
        System.out.println("获取项目"+basicProject);
        basicProject.setSerialNumber(DataUtil.getTimeUUID());
        basicProject.setExamination("0");
       // province=选择市, city=选择市, area=选择县/区
        if("选择省".equals(basicProject.getProvince())){
            basicProject.setProvince(null);
        }
        if("选择市".equals(basicProject.getCity())){
            basicProject.setCity(null);
        }
        if("选择县/区".equals(basicProject.getArea())){
            basicProject.setArea(null);
        }
        if("".equals(basicProject.getAStateOf())||basicProject.getAStateOf()==null){
            basicProject.setAStateOf("off");
        }
        if("".equals(basicProject.getWhetherOutsourcing())||basicProject.getWhetherOutsourcing()==null){
            basicProject.setWhetherOutsourcing("off");
        }
    //判断三种状态


        return  basicProjectMapper.insertBasucByserialNumber(basicProject);
    }

    /**
     * 项目审批
     * @param basicProject
     * @return
     */
    @Override
    public int examinationProject(BasicProject basicProject) {
        basicProject.setExamination("1");
       // 判断三种状态
        if("on".equals(basicProject.getWhetherOutsourcing())){//外包
            OutsourcingProject outsourcingProject=new OutsourcingProject();
            outsourcingProject.setSerialNumber(basicProject.getSerialNumber());
            outsourcingProject.setProjectName(basicProject.getProjectName());
            outsourcingProject.setGrossAmount(basicProject.getGrossAmount());
            epibolyProjectMapper.insetByOutsourcingProject(outsourcingProject);
        }else {
            SignedProject signedProject=new SignedProject();
        signedProject.setSerialNumber(basicProject.getSerialNumber());
        signedProject.setProjectName(basicProject.getProjectName());
        signedProject.setGrossAmount(basicProject.getGrossAmount());
        if("on".equals(basicProject.getAStateOf())){
            signedProject.setProjectProgress("未开展");
        }
            particularsProjectMapper.insetBySignedProject(signedProject);
        }
        return basicProjectMapper.updateBasucByserialNumber(basicProject);
    }

    @Override
    public int updateBasucByserialNumber(BasicProject basicProject) {
        return basicProjectMapper.updateBasucByserialNumber(basicProject);
    }

    /**
     * 分页查修
     * @return
     */
    @Override
    public PageResult selectPage(PageRequest pageRequest,BasicProject basicProject) {
        return PageUtils.getPageResult(pageRequest, getPageInfo(pageRequest,basicProject));
    }

    /**
     * 调用分页插件完成分页
     * @param
     * @return
     */
    private PageInfo<BasicProject> getPageInfo(PageRequest pageRequest,BasicProject basicProject) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        if("选择省".equals(basicProject.getProvince())){
            basicProject.setProvince(null);
        }
        if("选择市".equals(basicProject.getCity())){
            basicProject.setCity(null);
        }
        if("选择县/区".equals(basicProject.getArea())){
            basicProject.setArea(null);
        }
        List<BasicProject> sysMenus = basicProjectMapper.selectPage(basicProject);//设置关键词查询
        return new PageInfo<BasicProject>(sysMenus);
    }
}
