package com.fjtons.oaglxt.service;

import com.fjtons.oaglxt.pojo.AdminLog;
import com.fjtons.oaglxt.pojo.PageRequest;
import com.fjtons.oaglxt.pojo.PageResult;

import java.util.List;

public interface AdminLogService {
    List<AdminLog> selAllAdminLog(AdminLog adminLog);
    int   insertAdminLog(AdminLog adminLog);
    int deleteArrayAdminlog(String[] array);
    /**
     * 分页查修接口
     * @return
     */
    PageResult selectPage(PageRequest pageRequest, AdminLog adminLog);
}
