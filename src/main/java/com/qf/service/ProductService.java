package com.qf.service;

import com.qf.pojo.Product;

public interface ProductService {
    Product selectByPrimaryKey(Integer pid);
}
