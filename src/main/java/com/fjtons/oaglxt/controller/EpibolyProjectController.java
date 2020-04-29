package com.fjtons.oaglxt.controller;

import com.fjtons.oaglxt.pojo.BasicProject;
import com.fjtons.oaglxt.pojo.OutsourcingProject;
import com.fjtons.oaglxt.pojo.PageRequest;
import com.fjtons.oaglxt.service.EpiboloyProjectService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * 外包项目控制层
 */
@Controller
@RequestMapping("/Epiboloy")
public class EpibolyProjectController {
    @Resource
    private EpiboloyProjectService epiboloyProjectService;

    /**
     * 获取分页
     * @param  page, limit
     * @return
     * page=1&limit=10
     */
    @RequestMapping(value="/selectPage")
    @ResponseBody
    public Object selectPage2(int page, int limit, BasicProject basicProject) {
        //需要判断自己得权限
        //需要判断自己得权限
        OutsourcingProject outsourcingProject=new OutsourcingProject();
        outsourcingProject.setBasicProject(basicProject);
        PageRequest pageQuery=new PageRequest();
        pageQuery.setPageNum(page);
        pageQuery.setPageSize(limit);
        return epiboloyProjectService.selectPage(pageQuery,basicProject);
    }

    /**
     * 修改
     */
    @RequestMapping(value="/updataOutsourcingProject")
    @ResponseBody
    public  Object updataOutsourcingProject(OutsourcingProject outsourcingProject){
        System.out.println("修改"+outsourcingProject);
        return  epiboloyProjectService.updataByOutsourcingProject(outsourcingProject);
    }
    /**
     * 删除
     */
    @RequestMapping(value="/deletBySerialNumber")
    @ResponseBody
    public  Object deletBySerialNumber(String xuhao){
        return  epiboloyProjectService.deletBySerialNumber(xuhao);
    }
    /**
     * 批量删除
     */
    @RequestMapping(value="/deletBySerialNumberList")
    @ResponseBody
    public  Object deletBySerialNumberList(@RequestParam("lists")String[] xuhao){
        return  epiboloyProjectService.deletBySerialNumberList(xuhao);
    }
}
