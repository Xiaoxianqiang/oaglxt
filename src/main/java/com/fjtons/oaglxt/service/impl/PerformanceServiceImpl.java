/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: PerformanceServiceImpl
 * Author:   abc
 * Date:     2020/4/17 16:53
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.fjtons.oaglxt.service.impl;

import com.fjtons.oaglxt.mapper.PerformanceMapper;
import com.fjtons.oaglxt.pojo.PageRequest;
import com.fjtons.oaglxt.pojo.PageResult;
import com.fjtons.oaglxt.pojo.Performance;
import com.fjtons.oaglxt.service.PerformanceService;
import com.fjtons.oaglxt.utils.DataUtil;
import com.fjtons.oaglxt.utils.PageUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author abc
 * @create 2020/4/17
 * @since 1.0.0
 */
@Service
public class PerformanceServiceImpl implements PerformanceService {
    @Autowired
    private PerformanceMapper performanceMapper;

    @Override
    public PageResult selectPage(PageRequest pageRequest, Performance performance) {
        return  PageUtils.getPageResult(pageRequest, getPageInfo(pageRequest,performance));
    }

    @Override
    public int insertPerformance(Performance performance) {
        performance.setPersonnelId(DataUtil.getTimeUUID());
        return performanceMapper.insertPerformance(performance);
    }

    @Override
    public int updatePerformance(Performance performance) {
        return performanceMapper.updatePerformance(performance);
    }

    @Override
    public int deletePerformanceId(String[] array) {
        return performanceMapper.deletePerformanceId(array);
    }

    /**
     * 调用分页插件完成分页
     * @param
     * @return
     */
    private PageInfo<Performance> getPageInfo(PageRequest pageRequest, Performance performance) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<Performance> sysMenus = performanceMapper.selectPage(performance);//设置关键词查询
        return new PageInfo<Performance>(sysMenus);
    }
}