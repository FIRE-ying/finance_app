package com.qf.mapper;

import com.qf.pojo.Borrow;

public interface BorrowMapper {
    int deleteByPrimaryKey(Integer bid);

    int insert(Borrow record);

    int insertSelective(Borrow record);

    Borrow selectByPrimaryKey(Integer bid);

    int updateByPrimaryKeySelective(Borrow record);

    int updateByPrimaryKey(Borrow record);
}