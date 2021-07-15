package com.factorymethod;

import com.factorymethod.Product;

import java.util.HashMap;
import java.util.Map;

public class ChoiceFactory {
    public static final Map<String, Product> productCache = new HashMap<>();
    static {
        productCache.put("1",new ConcreateProduct());
    }
    public static Product createProuct(String prodStr){
        return productCache.get(prodStr);
    }
}
