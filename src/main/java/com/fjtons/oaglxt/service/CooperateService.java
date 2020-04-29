package com.fjtons.oaglxt.service;

import com.fjtons.oaglxt.pojo.Cooperate;
import com.fjtons.oaglxt.pojo.PageRequest;
import com.fjtons.oaglxt.pojo.PageResult;

import java.util.List;

public interface CooperateService {
    PageResult selectPage(PageRequest pageRequest, Cooperate cooperate);
    int deleteCooperateId(String[] array);
    int updateCooperater(Cooperate cooperate);
    int insertCooperate(Cooperate cooperate);
}
