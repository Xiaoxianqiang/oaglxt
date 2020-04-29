package com.fjtons.oaglxt.pojo;

import lombok.Data;

import java.util.List;

/**
 * 分页返回
 */
@Data
public class PageResult {

    /**
     * 返回的值
     */
    private  int code=0;

    /**
     * 当前页码
     */
    private int pageNum;
    /**
     * 每页数量
     */
    private int pageSize;
    /**
     * 记录总数
     */
    private long totalSize;
    /**
     * 记录总数2
     */
    private long count   ;
    /**
     * 页码总数
     */
    private int totalPages;
    /**
     * 数据模型
     */
    private List<?> data;
}
