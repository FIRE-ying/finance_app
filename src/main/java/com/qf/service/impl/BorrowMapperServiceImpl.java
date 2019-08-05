package com.qf.service.impl;

import com.qf.mapper.BorrowMapper;
import com.qf.pojo.Borrow;
import com.qf.service.BorrowMapperService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 生活很好，记得微笑🙂
 */
@Service
public class BorrowMapperServiceImpl implements BorrowMapperService {

    @Resource
    private BorrowMapper borrowMapper;


    @Override
    public List<Borrow> findallborrow() {
        return borrowMapper.findallborrow();
    }

    @Override
    @Transactional
    public int insertSelective(Borrow record) {
        return borrowMapper.insertSelective(record);
    }
}
