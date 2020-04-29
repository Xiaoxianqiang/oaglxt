package com.fjtons.oaglxt.pojo;

import lombok.Data;

/**
 * 分页请求对象
 */
@Data
public class PageRequest {
    /**
     * 当前页码
     */
    private int pageNum;
    /**
     * 每页数量
     */
    private int pageSize;
}
