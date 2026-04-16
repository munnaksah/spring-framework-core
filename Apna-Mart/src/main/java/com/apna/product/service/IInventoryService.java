package com.apna.product.service;

import org.springframework.stereotype.Service;

import com.apna.product.entity.InventoryEntity;

@Service
public interface IInventoryService {

	// Create or Update Inventory
	InventoryEntity saveInventory(InventoryEntity request);

	// Get Inventory by ProductId
	InventoryEntity getByProductId(Integer productId);
	
}
