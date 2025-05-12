package com.zn.springbootmall.dao.impl;

import com.zn.springbootmall.dao.ProductDao;
import com.zn.springbootmall.dto.ProductQueryParams;
import com.zn.springbootmall.dto.ProductRequest;
import com.zn.springbootmall.model.Product;
import com.zn.springbootmall.rowmapper.ProductRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ProductDaoImpl implements ProductDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public Integer countProduct(ProductQueryParams productQueryParams) {
        String sql = "SELECT count(*) FROM product WHERE 1=1";

        Map<String, Object> map = new HashMap<>();

        // 查詢條件
        if (productQueryParams.getCategory() != null) {
            sql += " AND category = :category"; //上面的 WHERE 1=1 可使這句 AND category = :category 可以直接接在後面
            map.put("category", productQueryParams.getCategory().name()); //使用 Enum 類型要先用 .Name 方法轉成字串才能加到 map 裡
        }

        if (productQueryParams.getSearch() != null) {
            sql += " AND product_name LIKE :search"; // LIKE 模糊查詢
            map.put("search", "%"+ productQueryParams.getSearch() +"%"); // % 代表任意字符
        }

        Integer total = namedParameterJdbcTemplate.queryForObject(sql, map, Integer.class); // 將 count 的值轉換成 Integer 類型的返回值

        return total;
    }

    @Override
    public List<Product> getProducts(ProductQueryParams productQueryParams) {
        String sql = "SELECT product_id, product_name, category, image_url, price, stock, description, " +
                "created_date, last_modified_date FROM product WHERE 1=1";

        Map<String, Object> map = new HashMap<>();

        // 查詢條件
        if (productQueryParams.getCategory() != null) {
            sql += " AND category = :category"; //上面的 WHERE 1=1 可使這句 AND category = :category 可以直接接在後面
            map.put("category", productQueryParams.getCategory().name()); //使用 Enum 類型要先用 .Name 方法轉成字串才能加到 map 裡
        }

        if (productQueryParams.getSearch() != null) {
            sql += " AND product_name LIKE :search"; // LIKE 模糊查詢
            map.put("search", "%"+ productQueryParams.getSearch() +"%"); // % 代表任意字符
        }

        // 排序
        sql += " ORDER BY " + productQueryParams.getOrderBy() + " " + productQueryParams.getSort();

        // 分頁
        sql += " LIMIT :limit OFFSET :offset ";
        map.put("limit", productQueryParams.getLimit());
        map.put("offset", productQueryParams.getOffset());

        List<Product> productList = namedParameterJdbcTemplate.query(sql, map, new ProductRowMapper());

        return productList;
    }

    @Override
    public Product getProductById(Integer productId) {

        String sql = "SELECT product_id, product_name, category, image_url, price, stock, description, " +
                "created_date, last_modified_date FROM product WHERE product_id = :productId";

        Map<String, Object> map = new HashMap<>();
        map.put("productId", productId);

        List<Product> productList = namedParameterJdbcTemplate.query(sql, map, new ProductRowMapper());

        if (productList.size() > 0) {
            return productList.get(0);
        }else {
            return null;
        }
    }

    @Override
    public Integer createProduct(ProductRequest productRequest) {
        String sql = "INSERT INTO product(product_name, category, image_url, price, stock, description, " +
        "created_date, last_modified_date) " +
                "VALUES (:productName, :category, :imageUrl, :price, :stock, :description, :createdDate," +
                " :lastModifiedDate)";

        Map<String, Object> map = new HashMap<>();
        map.put("productName", productRequest.getProductName());
        map.put("category", productRequest.getCategory().toString());
        map.put("imageUrl", productRequest.getImageUrl());
        map.put("price", productRequest.getPrice());
        map.put("stock", productRequest.getStock());
        map.put("description", productRequest.getDescription());

        Date now = new Date();
        map.put("createdDate", now);
        map.put("lastModifiedDate", now);

        KeyHolder keyHolder = new GeneratedKeyHolder();

        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(map), keyHolder);

        int productId = keyHolder.getKey().intValue();

        return productId;
    }

    @Override
    public void updateProduct(Integer productId, ProductRequest productRequest) {
        String sql = "UPDATE product SET product_name = :productName, category = :category," +
                " image_url = :imageUrl, price = :price, stock = :stock, description = :description," +
                " last_modified_date = :lastModifiedDate WHERE product_id = :productId ";

        Map<String, Object> map = new HashMap<>();
        map.put("productId", productId);

        map.put("productName", productRequest.getProductName());
        map.put("category", productRequest.getCategory().toString());
        map.put("imageUrl", productRequest.getImageUrl());
        map.put("price", productRequest.getPrice());
        map.put("stock", productRequest.getStock());
        map.put("description", productRequest.getDescription());

        map.put("lastModifiedDate", new Date());

        namedParameterJdbcTemplate.update(sql, map);
    }

    @Override
    public void deleteProductById(Integer productId) {
        String sql = "DELETE FROM product WHERE product_id = :productId";

        Map<String, Object> map = new HashMap<>();
        map.put("productId", productId);

        namedParameterJdbcTemplate.update(sql, map);
    }
}
