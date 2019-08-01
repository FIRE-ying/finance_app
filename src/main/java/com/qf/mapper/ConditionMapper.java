package com.qf.mapper;

import com.qf.pojo.Condition;

public interface ConditionMapper {
    int deleteByPrimaryKey(Integer cid);

    int insert(Condition record);

    int insertSelective(Condition record);

    Condition selectByPrimaryKey(Integer cid);

    int updateByPrimaryKeySelective(Condition record);

    int updateByPrimaryKey(Condition record);
}