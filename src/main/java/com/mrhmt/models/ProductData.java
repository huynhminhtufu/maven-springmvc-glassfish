package com.mrhmt.models;

import java.util.ArrayList;
import java.util.List;

public class ProductData {
    public static List<Product> listProduct = new ArrayList<Product>();
    public static boolean created = false;

    public static void loadData() {
        listProduct.add(new Product(1, "Sữa", 12, 1));
        listProduct.add(new Product(2, "Bánh", 24, 2));
        listProduct.add(new Product(3, "Đậu Xanh", 48, 3));
        listProduct.add(new Product(4, "Rau Má", 96, 4));
    }
}
