package com.zepto.product.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.zepto.product.request.ProductRequest;
import com.zepto.product.request.ProductResponse;

@Controller
public class ProductController {
	
	
	@PostMapping("uploadProduct")
	public String uploadProduct(@ModelAttribute  ProductRequest  productRequest , Model model) {
		
	String productName = 	productRequest.getProductName();
	String qty = productRequest.getQty();
	String description = productRequest.getDescription();
	String price  = productRequest.getPrice();
	String soldBy = productRequest.getSoldBy();
	
	
	
	
	
		
	
	System.out.println("Received from seller :" + productName + " "  + qty + " " + description + " "  +  price + " "   +  soldBy );
		
//	  some token id
		String input = productName  + qty;
		String productId = java.util.UUID.nameUUIDFromBytes(input.getBytes()).toString().replace("-", "").substring(0, 5)
				.toUpperCase();
//		System.out.println("Generated Ref id " + productId);
	
	
	
	ProductResponse productResponse = new ProductResponse();
	productResponse.setProductId(productId);
	productResponse.setConfirmationMSG(
		    "🎉 Success! Your product has been uploaded successfully and will be visible on the catalog after review."
		);
//	productResponse.setConfirmationMSG("your product  has been be upload. it will live on catalog!");
	
	// it will give the response 
	model.addAttribute("response", productResponse);
	
	return "product-confirm";
		
		
		
	}

}
