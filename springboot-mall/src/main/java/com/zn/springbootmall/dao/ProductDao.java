package com.zn.springbootmall.dao;

import com.zn.springbootmall.constant.ProductCategory;
import com.zn.springbootmall.dto.ProductRequest;
import com.zn.springbootmall.model.Product;
import java.util.List;

public interface ProductDao {

    List<Product> getProducts(ProductCategory category, String search);

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);

    void deleteProductById(Integer productId);
}
