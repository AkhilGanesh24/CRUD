package com.crud.products.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.crud.products.dao.ProductsRepository;
import com.crud.products.exception.ProductNotFoundException;
import com.crud.products.model.Product;

@Service
public class ProductService {

	@Autowired
	ProductsRepository productRepository;

	public Iterable getProducts() {
		return productRepository.findAll();

	}

	public Product createProduct(Product productObj) {
		return productRepository.save(productObj);
	}

	public Product RetrieveProduct(Integer productId) {

		return productRepository.findById(productId).orElse(null);

	}

	public Product updateProduct(Integer productId, BigDecimal price) {

		Product product = RetrieveProduct(productId);
		if (product == null) {
			throw new ProductNotFoundException("Unable to find the Product");
		} else {
			product.setPrice(price);
			return productRepository.save(product);
		}

	}

	public void deleteProduct(Integer productId) {

		findByProductID(null, productId);
		productRepository.deleteById(productId);
	}

	public Product findByProductName(String productName, Integer id) {

		Product product = productRepository.findByNameOrId(productName, id);
		if (product == null) {
			throw new ProductNotFoundException("Product Name Does Not Exists");
		} else {
			return product;
		}
	}

	public Product findByProductID(String productName, Integer id) {

		Product product = productRepository.findByNameOrId(productName, id);
		if (product == null) {
			throw new ProductNotFoundException("Product ID DoesNot Exists");
		} else {
			return product;
		}

	}
}
