package com.mrhmt.models;

import java.util.ArrayList;
import java.util.List;

public class ProductData {
    public static List<Product> listProduct = new ArrayList<Product>();
    public static boolean created = false;

    public static void loadData() {
        listProduct.add(new Product(1, "Sua", 12, 1));
        listProduct.add(new Product(2, "Banh", 24, 2));
        listProduct.add(new Product(3, "Dau Xanh", 48, 3));
        listProduct.add(new Product(4, "Rau Ma", 96, 4));
    }
}
