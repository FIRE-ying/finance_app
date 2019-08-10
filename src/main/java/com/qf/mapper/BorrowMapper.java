package com.qf.mapper;

import com.qf.pojo.Borrow;

import java.util.List;
import java.util.Map;

public interface BorrowMapper {

    public List<Borrow> findallborrow();
    //查询未审核用户信息列表
    public List<Borrow> selectBorrow();
    public  List<Borrow> selectSchedule(String uid);

    int deleteByPrimaryKey(Integer bid);

    List<Borrow> findByStatus(int uid, int status);
    int insert(Borrow record);

    int insertSelective(Borrow record);

    Borrow selectByPrimaryKey(Integer bid);

    int updateByPrimaryKeySelective(Borrow record);

    int updateByPrimaryKey(Borrow record);

    List<Borrow>  findbyuid(String uid);

    int updateborrowbybid(Integer bid);

}
