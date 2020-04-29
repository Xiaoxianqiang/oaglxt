package com.fjtons.oaglxt.controller;

import com.fjtons.oaglxt.pojo.BasicProject;
import com.fjtons.oaglxt.pojo.PageRequest;
import com.fjtons.oaglxt.pojo.SignedProject;
import com.fjtons.oaglxt.service.ParticularsProjectService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/Particulars")
public class ParticularsProjectController {
    @Resource
    private ParticularsProjectService particularsProjectService;
    /**
     * 获取分页
     * @param  page, limit
     * @return
     * page=1&limit=10
     */
    @RequestMapping(value="/selectPage")
    @ResponseBody
    public Object selectPage(int page, int limit, BasicProject basicProject) {
        //需要判断自己得权限
        SignedProject signedProject=new SignedProject();
        signedProject.setBasicProject(basicProject);
        PageRequest pageQuery=new PageRequest();
        pageQuery.setPageNum(page);
        pageQuery.setPageSize(limit);
        return particularsProjectService.selectPage(pageQuery,signedProject);
    }
    /**
     * 获取分页  对接
     * @param  page, limit
     * @return
     * page=1&limit=10
     */
    @RequestMapping(value="/selAllDocking")
    @ResponseBody
    public Object selAllDocking(int page, int limit, BasicProject basicProject) {
        //需要判断自己得权限
        SignedProject signedProject=new SignedProject();
        signedProject.setBasicProject(basicProject);
        PageRequest pageQuery=new PageRequest();
        pageQuery.setPageNum(page);
        pageQuery.setPageSize(limit);
        return particularsProjectService.selAllDocking(pageQuery,signedProject);
    }
    /**
     * 获取分页  未对接
     * @param  page, limit
     * @return
     * page=1&limit=10
     */
    @RequestMapping(value="/selAllNotDocking")
    @ResponseBody
    public Object selAllNotDocking(int page, int limit, BasicProject basicProject) {
        //需要判断自己得权限
        SignedProject signedProject=new SignedProject();
        signedProject.setBasicProject(basicProject);
        PageRequest pageQuery=new PageRequest();
        pageQuery.setPageNum(page);
        pageQuery.setPageSize(limit);
        return particularsProjectService.selAllNotDocking(pageQuery,signedProject);
    }
    /**
     * 获取分页  落地
     * @param  page, limit
     * @return
     * page=1&limit=10
     */
    @RequestMapping(value="/selAllLanding")
    @ResponseBody
    public Object selAllLanding(int page, int limit, BasicProject basicProject) {
        //需要判断自己得权限
        SignedProject signedProject=new SignedProject();
        signedProject.setBasicProject(basicProject);
        PageRequest pageQuery=new PageRequest();
        pageQuery.setPageNum(page);
        pageQuery.setPageSize(limit);
        return particularsProjectService.selAllLanding(pageQuery,signedProject);
    }
    /**
     * 获取分页  完成
     * @param  page, limit
     * @return
     * page=1&limit=10
     */
    @RequestMapping(value="/selAllComplete")
    @ResponseBody
    public Object selAllComplete(int page, int limit, BasicProject basicProject) {
        //需要判断自己得权限
        SignedProject signedProject=new SignedProject();
        signedProject.setBasicProject(basicProject);
        PageRequest pageQuery=new PageRequest();
        pageQuery.setPageNum(page);
        pageQuery.setPageSize(limit);
        return particularsProjectService.selAllComplete(pageQuery,signedProject);
    }
    /**
     * 获取分页  终止
     * @param  page, limit
     * @return
     * page=1&limit=10
     */
    @RequestMapping(value="/selAllTermination")
    @ResponseBody
    public Object selAllTermination(int page, int limit, BasicProject basicProject) {
        //需要判断自己得权限
        SignedProject signedProject=new SignedProject();
        signedProject.setBasicProject(basicProject);
        PageRequest pageQuery=new PageRequest();
        pageQuery.setPageNum(page);
        pageQuery.setPageSize(limit);
        return particularsProjectService.selAllTermination(pageQuery,signedProject);
    }

    /**
     * 修改数据
     */
    /**
     * 修改
     */
    @RequestMapping(value="/updataSignedProject")
    @ResponseBody
    public  Object updataSignedProject(SignedProject signedProject){
        System.out.println("修改"+signedProject);
     return  particularsProjectService.updataSignedProject(signedProject);
    }


    /**
     * 删除
     */
    @RequestMapping(value="/deleteSignedProject")
    @ResponseBody
    public  Object    deleteSignedProject(String serialNumber){
        return  particularsProjectService.deleteSignedProject(serialNumber);
    }
    /**
     * 批量删除
     */
    @RequestMapping(value="/deleteSignedProjectList")
    @ResponseBody
    public  Object   deleteSignedProjectList(@RequestParam("lists")String[] serialNumber){
        return  particularsProjectService.deleteSignedProjectList(serialNumber);
    }
}
