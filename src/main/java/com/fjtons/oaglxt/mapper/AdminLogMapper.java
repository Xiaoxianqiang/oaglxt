package com.fjtons.oaglxt.mapper;

import com.fjtons.oaglxt.pojo.AdminLog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminLogMapper {
    List<AdminLog> selAllAdminLog(AdminLog adminLog);
       int      insertAdminLog(AdminLog adminLog);
    int deleteArrayAdminlog(String[] array);
}
