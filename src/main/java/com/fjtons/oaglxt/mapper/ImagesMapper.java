package com.fjtons.oaglxt.mapper;

import com.fjtons.oaglxt.pojo.Images;

import java.util.List;

public interface ImagesMapper {
    /**
     *      利用项目id查修图片
     */
    List<Images> selByProjectId(String projectId);


    /**
     * 项目id删除图片
     */
int deleteByProjectId(String projectId);
    /**
     *  添加图片
     */
int insertImges(Images images);

    /*
    不能修改
     */
}
