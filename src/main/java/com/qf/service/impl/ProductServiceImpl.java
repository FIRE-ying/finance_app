package com.qf.service.impl;

import com.qf.mapper.ProductMapper;
import com.qf.pojo.Product;
import com.qf.service.ProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @program: finance_app2
 * @description: chanpin
 * @author: 李显辉
 * @create: 2019/08/08 10:34
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Resource
    private ProductMapper mapper;


    @Override
    public Product selectByPrimaryKey(Integer pid) {
        return mapper.selectByPrimaryKey(pid);
    }
}
