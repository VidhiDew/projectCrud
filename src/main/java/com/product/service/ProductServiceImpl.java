package com.product.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.entity.Product;
import com.product.repository.ProductRepossitory;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepossitory productRepo;
	
	@Override
	public Product addProduct(Product product) {
		Product saveProduct = productRepo.save(product);
		return saveProduct;
	}
	
	@Override
	public List<Product> getAllProduct() {
		List<Product> products = productRepo.findAll();//it provide runtime implementation 
		return products;
	}

	@Override
	public Product getProductById(Long id) {
		return productRepo.findById(id).orElseThrow(()->new RuntimeException("Product Not Found"));
		
	}

	@Override
	public Product updateProduct(Long id, Product product) {
		Product existingProduct = getProductById(id);
		existingProduct.setName(product.getName());
		existingProduct.setPrice(product.getPrice());
		existingProduct.setQuantity(product.getQuantity());
		return productRepo.save(existingProduct);
	}

	@Override
	public void deleteProduct(Long id) {
		productRepo.deleteById(id);
	}
	
}
