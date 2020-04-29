/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: CooperateController
 * Author:   abc
 * Date:     2020/4/15 17:24
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.fjtons.oaglxt.controller;

import com.fjtons.oaglxt.pojo.Cooperate;
import com.fjtons.oaglxt.pojo.PageRequest;
import com.fjtons.oaglxt.service.CooperateService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author abc
 * @create 2020/4/15
 * @since 1.0.0
 */
@Controller
@RequestMapping("/Cooperate")
public class CooperateController {
    @Resource
    private CooperateService cooperateService;
    /**
     * 获取分页
     * @param  page, limit
     * @return
     * page=1&limit=10
     */
    @RequestMapping(value="/selectPage")
    @ResponseBody
    public Object selectPage(int page, int limit, Cooperate Cooperate) {
        //需要判断自己得权限
        PageRequest pageQuery=new PageRequest();
        pageQuery.setPageNum(page);
        pageQuery.setPageSize(limit);
        return cooperateService.selectPage(pageQuery,Cooperate);
    }
    /**
     * 删除
     */
    @RequestMapping("/deleteCooperateId")
    @ResponseBody
    public  Object deleteCooperateId(String[] lists){
        return  cooperateService.deleteCooperateId(lists);
    }
    /**
     * 插入
     */
    @RequestMapping("/insertCooperate")
    @ResponseBody
    public  Object insertCooperate(Cooperate cooperate){
        return  cooperateService.insertCooperate(cooperate);
    }
    /**
     * 修改
     */
    @RequestMapping("/updateCooperater")
    @ResponseBody
    public  Object updateCooperater(Cooperate cooperate){ return  cooperateService.updateCooperater(cooperate);}
}