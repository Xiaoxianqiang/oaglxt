package com.fjtons.oaglxt.mapper;

import com.fjtons.oaglxt.pojo.SignedProject;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

//项目详情表（签订与未签订项目）
@Mapper
public interface ParticularsProjectMapper {
    /**
     * 查询
     */
/**
 * 分页查询
 */
List<SignedProject> selAll(SignedProject signedProject);
/**
 * 分页查询  未对接项目  project_progress="未开展"
 */
List<SignedProject> selAllNotDocking(SignedProject signedProject);
/**
 * 分页查询 对接项目  project_progress="项目信息确认" project_progress= "报价方案送出"
 */
List<SignedProject> selAllDocking(SignedProject signedProject);
/**
 * 分页查询  落地项目 project_progress="预付款已付" project_progress= "进度款A已付" 进度款B已付 待验收
 */
List<SignedProject> selAllLanding(SignedProject signedProject);
/**
 *分页查询  完成项目   项目完成(只保金未收)  项目完成  complete
 */
List<SignedProject> selAllComplete(SignedProject signedProject);
/**
 * 分页查询   终止项目      项目终止  除项目终止以外 Termination
 */
List<SignedProject> selAllTermination(SignedProject signedProject);
    /**
     * 添加
     */
/**
 * 添加信息
  * @param signedProject
 * @return
 */
int insetBySignedProject(SignedProject signedProject);
/**
 * 修改
 */
int updataSignedProject(SignedProject signedProject);
/**
 * 删除
 */
int   deleteSignedProject(String serialNumber);
}
