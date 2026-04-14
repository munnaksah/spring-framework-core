package com.blinkit.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.blinkit.product.request.ProductRequest;
import com.blinkit.product.request.ProductResponse;
import com.blinkit.product.service.IProductService;


@Controller
public class ProductController {
	
	@Autowired
	IProductService iProductService;
	
	
	
	
	@PostMapping("uploadProduct")
	public String uploadProduct(@ModelAttribute  ProductRequest  productRequest , Model model) {
		
		// calling service layer
		ProductResponse productResponse = 	iProductService.createProduct(productRequest);
		
		
		model.addAttribute("response", productResponse);
		
		return "product-confirm";
}
	
	
	

}
