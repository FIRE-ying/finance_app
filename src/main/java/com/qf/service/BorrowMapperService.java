package com.qf.service;

import com.qf.pojo.Borrow;
import com.qf.vo.HistoryVO;

import java.util.List;

public interface BorrowMapperService {


    public List<Borrow> findallborrow();
    public List<Borrow> selectBorrow();
    public  List<Borrow> selectSchedule(String uid);

    public int insertSelective(Borrow record);

    int repayment(int bid);

    Borrow selectByPrimaryKey(Integer bid);

    HistoryVO findByStatus(int uid, int status);


}
