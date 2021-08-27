package com.springapiforvuejs.repository;

import java.util.ArrayList;
import java.util.List;

import com.springapiforvuejs.model.Product;

import org.springframework.stereotype.Repository;

@Repository
public class ProductRepo {

    private final static List<Product> list = new ArrayList<>();

    static {
        init();
    }
    
    static void init() {
        list.add(new Product("Xiaomi Redmi Note 10 5G", "Wi-Fi 802.11 a/b/g/n/ac, dual-band, Wi-Fi Direct, hotspot", 345.32f, "https://cdn.cellphones.com.vn/media/catalog/product/cache/7/image/9df78eab33525d08d6e5fb8d27136e95/r/e/redmi-note-10-5g.jpg"));
        list.add(new Product("Vsmart Live 4", "Wi-Fi 802.11 a/b/g/n/ac, dual-band, Wi-Fi Direct, hotspot", 232.42f, "https://cdn.cellphones.com.vn/media/catalog/product/cache/7/image/9df78eab33525d08d6e5fb8d27136e95/v/s/vsmart-live-_4_1_.jpg"));
        list.add(new Product("Nokia 5.4", "Wi-Fi 802.11 a/b/g/n/ac, dual-band, Wi-Fi Direct, hotspot", 325.32f, "https://cdn.cellphones.com.vn/media/catalog/product/cache/7/image/9df78eab33525d08d6e5fb8d27136e95/n/o/nokia-5-4-xanh_1.png"));
        list.add(new Product("Vsmart Star 5", "Wi-Fi 802.11 a/b/g/n/ac, dual-band, Wi-Fi Direct, hotspot", 342.23f, "https://cdn.cellphones.com.vn/media/catalog/product/cache/7/image/9df78eab33525d08d6e5fb8d27136e95/v/s/vsmart-star-5-1_3.jpg"));
        list.add(new Product("Xiaomi Redmi 9C 3GB - 64GB", "Wi-Fi 802.11 a/b/g/n/ac, dual-band, Wi-Fi Direct, hotspot", 522.53f, "https://cdn.cellphones.com.vn/media/catalog/product/cache/7/image/9df78eab33525d08d6e5fb8d27136e95/r/e/redmi-9c_3__1_2.jpg"));

    }
    
    public List<Product> getAll() {
        return list;
    }
    
}
