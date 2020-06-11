package com.application.dao;

import com.application.model.Product;

import java.util.List;

public interface ProductDao extends GenericDao<Product, Integer> {

    List<Product> findByBrand(String brand);

    List<Product> findAvailableProducts();
}
