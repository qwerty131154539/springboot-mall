package com.zn.springbootmall.constant;

public class MyTest {

    public static void main(String[] args) {
        ProductCategory category = ProductCategory.COOKIE;
        String s = category.name();
        System.out.println(s);

        String s1 = "SNACK";
        ProductCategory category1 = ProductCategory.valueOf(s1);
    }
}
