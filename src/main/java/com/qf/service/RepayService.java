package com.qf.service;

import com.qf.pojo.Borrow;
import com.qf.utils.ResponseMessage;

import java.util.List;
import java.util.Map;

public interface RepayService {
    List<ResponseMessage> findbyuid(String uid);
    Map<String,String>  payed(Integer bid,String password);
}
