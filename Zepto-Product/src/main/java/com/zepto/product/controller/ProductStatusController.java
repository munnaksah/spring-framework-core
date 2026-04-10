package com.zepto.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zepto.product.entity.ProductEntity;
import com.zepto.product.service.IProductService;

@Controller
public class ProductStatusController {
	
	@Autowired
	IProductService iProductService;
	
	
	@GetMapping("checkProductStatus")
	@ResponseBody
	public String checkStatus(@RequestParam("productId") String productId) {
		

        int productIDInt = Integer.parseInt(productId);
        String status = iProductService.checkProductStatus(productIDInt);
        
        return "Status of your product is : " + status;
		
	}
	     // getAll products
	
	 @GetMapping("allProducts")
	    public String getAllProducts(Model model) {
	        List<ProductEntity> products = iProductService.getAllProducts();
	        System.out.println("Products List: " + products);
	        model.addAttribute("products", products);
	        return "allProducts"; // loads allProducts.jsp
	    }
	 
	 
	 // for update product
	 @PostMapping("/updateStatus")
	 public String updateStatus(
	         @RequestParam("id") int id,
	         @RequestParam("status") String status) {

		 iProductService.updateStatus(id, status);

	     return "redirect:/allProducts";
	 }
	 
	 
	 @GetMapping("/editProductStatus")
	 public String editProductStatus(@RequestParam("id") int id, Model model) {

	     ProductEntity product = iProductService.getProductById(id);

	     model.addAttribute("product", product);

	     return "editProduct";
	 }
}
