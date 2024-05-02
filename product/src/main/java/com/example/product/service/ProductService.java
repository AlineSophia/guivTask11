package com.example.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.product.entity.Product;
import com.example.product.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> getProductsList(){
		List<Product> prod = productRepository.findAll();
		return prod;
	}
	
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}

}
