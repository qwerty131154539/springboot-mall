package com.zn.springbootmall.service;

import com.zn.springbootmall.dto.ProductRequest;
import com.zn.springbootmall.model.Product;

public interface ProductService {

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);
}
