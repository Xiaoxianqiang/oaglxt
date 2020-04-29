/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: CooperateServiceImpl
 * Author:   abc
 * Date:     2020/4/15 17:18
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.fjtons.oaglxt.service.impl;

import com.fjtons.oaglxt.mapper.CooperateMapper;
import com.fjtons.oaglxt.pojo.Cooperate;
import com.fjtons.oaglxt.pojo.PageRequest;
import com.fjtons.oaglxt.pojo.PageResult;
import com.fjtons.oaglxt.service.CooperateService;
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
 * @create 2020/4/15
 * @since 1.0.0
 */
@Service
public class CooperateServiceImpl implements CooperateService {

    @Autowired
    private CooperateMapper cooperateMapper;

    @Override
    public PageResult selectPage(PageRequest pageRequest, Cooperate cooperate) {
        return  PageUtils.getPageResult(pageRequest, getPageInfo(pageRequest,cooperate));
    }

    @Override
    public int deleteCooperateId(String[] array) {
        return cooperateMapper.deleteCooperateId(array);
    }

    @Override
    public int updateCooperater(Cooperate cooperate) {
        return cooperateMapper.updateCooperater(cooperate);
    }

    @Override
    public int insertCooperate(Cooperate cooperate) {
        cooperate.setCooperateId(DataUtil.getTimeUUID());
        return cooperateMapper.insertCooperate(cooperate);
    }





    /**
     * 调用分页插件完成分页
     * @param
     * @return
     */
    private PageInfo<Cooperate> getPageInfo(PageRequest pageRequest, Cooperate cooperate) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<Cooperate> sysMenus = cooperateMapper.selectPage(cooperate);//设置关键词查询
        return new PageInfo<Cooperate>(sysMenus);
    }
}