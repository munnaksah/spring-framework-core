package com.apna.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.apna.product.entity.InventoryEntity;
import com.apna.product.service.IInventoryService;

@Controller
public class InventoryController {
	@Autowired
	IInventoryService iInventoryService;
	
	
	 @PostMapping("inventory")
	    public InventoryEntity saveInventory(@RequestBody InventoryEntity request) {
	        return iInventoryService.saveInventory(request);
	    }
	 
	 
	 @GetMapping("/{productId}")
	    public InventoryEntity getInventory(@PathVariable Integer productId) {
	        return iInventoryService.getByProductId(productId);
	    }

}
