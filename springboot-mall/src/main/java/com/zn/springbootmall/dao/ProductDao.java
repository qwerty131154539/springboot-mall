package com.zn.springbootmall.dao;

import com.zn.springbootmall.model.Product;

public interface ProductDao {

    Product getProductById(Integer productId);
}
