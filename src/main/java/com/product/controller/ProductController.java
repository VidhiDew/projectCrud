package com.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.product.entity.Product;
import com.product.service.ProductService;

@RestController
@RequestMapping("/api/product")		//Common URL for All Rest API method
public class ProductController {

	@Autowired
	private ProductService productService;
	
	
	@PostMapping(		//To send data from client to server
				consumes = {"application/xml","application/json"},//Rest API method can take input[Content-Type]
				produces={"application/json","application/xml"}//Rest API method can provide output [Accept]
			)
	public ResponseEntity<Product> createProduct(@RequestBody Product product) {
		Product product2 = productService.addProduct(product);
		ResponseEntity<Product> responseEntity = new ResponseEntity<>(product2, HttpStatus.CREATED);
		return responseEntity;
	}
	
	@GetMapping("/getAllProduct")
	public ResponseEntity<List<Product>> getAllProduct(){
		return new ResponseEntity<>(productService.getAllProduct(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable Long id) {
		return new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteProductById(@PathVariable Long id){
		productService.deleteProduct(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Product> UpdateProductById(@PathVariable Long id, @RequestBody Product product){
		Product product2 = productService.updateProduct(id, product);
		return new ResponseEntity<>(product2, HttpStatus.CREATED);
	}
}
