package com.product.service;

import java.util.List;
import java.util.Optional;

import com.product.entity.Product;

public interface ProductService {

	public List<Product> getAllProduct();
	
	public Product getProductById(Long id);
	
	public Product addProduct(Product product);
	
	public Product updateProduct(Long id, Product product);
	
	public void deleteProduct(Long id);
}
