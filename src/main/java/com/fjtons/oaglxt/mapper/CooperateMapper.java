package com.fjtons.oaglxt.mapper;

import com.fjtons.oaglxt.pojo.Cooperate;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CooperateMapper {
List<Cooperate> selectPage(Cooperate cooperate);
int deleteCooperateId(String[] array);
int updateCooperater(Cooperate cooperate);
int insertCooperate(Cooperate cooperate);
}
