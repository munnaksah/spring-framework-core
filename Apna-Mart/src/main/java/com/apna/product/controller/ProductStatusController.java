package com.apna.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.apna.product.service.IProductService;

@Controller
public class ProductStatusController {
	
	@Autowired
	IProductService iProductService;
	
	
	@GetMapping("checkProductStatus")
	@ResponseBody
	public String checkStatus( @RequestParam ("id") int id) {
		
		String productResponse =	iProductService.checkProductStatus(id);
		
		
		return "Status of your product:"+ productResponse;
		
	}

}
