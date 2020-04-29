package com.fjtons.oaglxt.service;

import com.fjtons.oaglxt.pojo.PageRequest;
import com.fjtons.oaglxt.pojo.PageResult;
import com.fjtons.oaglxt.pojo.Performance;

public interface PerformanceService {
    PageResult selectPage(PageRequest pageRequest, Performance performance);


    int insertPerformance(Performance performance);
    int updatePerformance(Performance performance);
    int deletePerformanceId(String[] array);
}
