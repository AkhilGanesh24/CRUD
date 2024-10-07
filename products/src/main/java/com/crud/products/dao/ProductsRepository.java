package com.crud.products.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.crud.products.model.Product;

@Repository
public interface ProductsRepository extends CrudRepository<Product, Integer> {

	Product findByNameOrId(String productName, Integer id);

}
