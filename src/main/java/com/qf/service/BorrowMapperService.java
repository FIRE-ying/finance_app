package com.qf.service;

import com.qf.pojo.Borrow;

import java.util.List;

public interface BorrowMapperService {


    public List<Borrow> findallborrow();

    public int insertSelective(Borrow record);


}
