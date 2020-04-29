/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: AdminLogServiceImpl
 * Author:   abc
 * Date:     2020/4/12 9:33
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.fjtons.oaglxt.service.impl;

import com.fjtons.oaglxt.mapper.AdminLogMapper;
import com.fjtons.oaglxt.pojo.AdminLog;
import com.fjtons.oaglxt.pojo.PageRequest;
import com.fjtons.oaglxt.pojo.PageResult;
import com.fjtons.oaglxt.service.AdminLogService;
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
 * @create 2020/4/12
 * @since 1.0.0
 */
@Service
public class AdminLogServiceImpl implements AdminLogService {
    @Autowired
    private AdminLogMapper adminLogMapper;

    @Override
    public List<AdminLog> selAllAdminLog(AdminLog adminLog) {
        return null;
    }

    @Override
    public int insertAdminLog(AdminLog adminLog) {
        return adminLogMapper.insertAdminLog(adminLog);
    }

    @Override
    public int deleteArrayAdminlog(String[] array) {
        return adminLogMapper.deleteArrayAdminlog(array);
    }

    @Override
    public PageResult selectPage(PageRequest pageRequest, AdminLog adminLog) {
        return  PageUtils.getPageResult(pageRequest, getPageInfo(pageRequest,adminLog));
    }

    /**
     * 调用分页插件完成分页
     * @param
     * @return
     */
    private PageInfo<AdminLog> getPageInfo(PageRequest pageRequest, AdminLog adminLog) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<AdminLog> sysMenus = adminLogMapper.selAllAdminLog(adminLog);//设置关键词查询
        return new PageInfo<AdminLog>(sysMenus);
    }
}