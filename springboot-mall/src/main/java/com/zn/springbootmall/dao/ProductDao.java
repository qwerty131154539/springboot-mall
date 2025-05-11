package com.zn.springbootmall.dao;

import com.zn.springbootmall.dto.ProductRequest;
import com.zn.springbootmall.model.Product;

public interface ProductDao {

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);
}
