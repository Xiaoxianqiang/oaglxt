package com.fjtons.oaglxt.service.impl;

import com.fjtons.oaglxt.mapper.BasicProjectMapper;
import com.fjtons.oaglxt.mapper.EpibolyProjectMapper;
import com.fjtons.oaglxt.pojo.BasicProject;
import com.fjtons.oaglxt.pojo.OutsourcingProject;
import com.fjtons.oaglxt.pojo.PageRequest;
import com.fjtons.oaglxt.pojo.PageResult;
import com.fjtons.oaglxt.service.BasicProjectService;
import com.fjtons.oaglxt.service.EpiboloyProjectService;
import com.fjtons.oaglxt.utils.PageUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Service
public class EpiboloyProjectServiceImpl implements EpiboloyProjectService {
    @Autowired
    BasicProjectMapper basicProjectMapper;
    @Autowired
    private EpibolyProjectMapper epiboloyProjectMapper;


    @Override
    public int insetByOutsourcingProject(OutsourcingProject outsourcingProject) {
        return epiboloyProjectMapper.insetByOutsourcingProject(outsourcingProject);
    }

    @Override
    public int updataByOutsourcingProject(OutsourcingProject outsourcingProject) {
        return epiboloyProjectMapper.updataByOutsourcingProject(outsourcingProject);
    }

    @Override
    public int deletBySerialNumber(String serialNumber) {
        basicProjectMapper.deletBasucByserialNumber(serialNumber);
        return epiboloyProjectMapper.deletBySerialNumber(serialNumber);
    }
    @Override
    public  int deletBySerialNumberList(String[] serialNumber){
        for (int i=0;i<serialNumber.length;i++){
            epiboloyProjectMapper.deletBySerialNumber(serialNumber[i]);
            basicProjectMapper.deletBasucByserialNumber(serialNumber[i]);
        }
        return  1;
    }


    @Override
    public PageResult selectPage(PageRequest pageRequest, BasicProject basicProject) {
        return PageUtils.getPageResult(pageRequest, getPageInfo(pageRequest,basicProject));

    }

    /**
     * 调用分页插件完成分页
     * @param
     * @return
     */
    private PageInfo<BasicProject> getPageInfo(PageRequest pageRequest, BasicProject basicProject) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<BasicProject> sysMenus = epiboloyProjectMapper.selectPage(basicProject);//设置关键词查询
        return new PageInfo<BasicProject>(sysMenus);
    }


}
