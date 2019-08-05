package com.qf.mapper;

import com.qf.pojo.Borrow;

import java.util.List;
import java.util.Map;

public interface BorrowMapper {

    public List<Borrow> findallborrow();

    int deleteByPrimaryKey(Integer bid);

    int insert(Borrow record);

    int insertSelective(Borrow record);

    Borrow selectByPrimaryKey(Integer bid);

    int updateByPrimaryKeySelective(Borrow record);

    int updateByPrimaryKey(Borrow record);
}