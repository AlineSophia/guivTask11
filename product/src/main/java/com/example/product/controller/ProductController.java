package com.example.product.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.product.entity.Product;
import com.example.product.service.ProductService;

@Controller
public class ProductController {
	
    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	private ProductService productService;
	
	//to get the index page
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	//to get the list of products available
	@GetMapping(value="/listOfProducts")
	public String getAllProduct(Model model) {
		List<Product> products=productService.getProductsList();
		model.addAttribute("products", products);
		return "displayProduct";
	}
	
	@GetMapping("/addProduct")
	public String getAddProduct() {
		return "addProduct";
	}
	
	//Creating a post method to save the product
	@PostMapping(value="/submitProduct")
	public String addProducts(@ModelAttribute Product product) {
		productService.saveProduct(product);
		//redirect to display page after adding the product
		return "redirect:/";
	}
	

}
