package com.apna.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.apna.product.entity.PriceEntity;
import com.apna.product.entity.ProductEntity;
import com.apna.product.request.PriceRequest;
import com.apna.product.service.IPriceService;

@Controller
public class PriceController {
	
	@Autowired
	IPriceService iPriceService;
	
	
	@GetMapping("price")
	public String createPrice(@ModelAttribute  PriceRequest request, Model model) {
		
		PriceEntity entity = new PriceEntity();
		ProductEntity productentity = new ProductEntity();
		productentity.setId(request.getProductId());
		
		entity.setCurrencyCode(request.getCurrencyCode());
		entity.setPrice(request.getPrice());
		entity.setStatus("ACTIVE");
		 PriceEntity saved = iPriceService.createPrice(entity);
		 model.addAttribute("price", saved);

		    return "price-confirm";
		
		
	
		
	}
	
	   @GetMapping("/{id}")
	    public PriceEntity getPrice(@PathVariable Integer id) {
	        return iPriceService.getPriceById(id);
	    }

}
