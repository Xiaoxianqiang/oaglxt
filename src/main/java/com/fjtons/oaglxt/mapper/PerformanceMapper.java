package com.fjtons.oaglxt.mapper;

import com.fjtons.oaglxt.pojo.Performance;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PerformanceMapper {
    //insertPerformance  updatePerformance selectPage deletePerformanceId
    List<Performance> selectPage(Performance performance);
    int insertPerformance(Performance performance);
    int updatePerformance(Performance performance);
    int deletePerformanceId(String[] array);
}
