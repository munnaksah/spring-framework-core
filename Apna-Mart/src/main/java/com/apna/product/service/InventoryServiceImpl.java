package com.apna.product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apna.product.entity.InventoryEntity;
import com.apna.product.entity.ProductEntity;
import com.apna.product.repository.InventoryRepository;
import com.apna.product.repository.ProductRepository;

@Service
public class InventoryServiceImpl implements IInventoryService {

	@Autowired
	InventoryRepository inventoryRepository;

	@Autowired
	ProductRepository productRepository;

	@Override
	public InventoryEntity saveInventory(InventoryEntity request) {

		ProductEntity product = productRepository.findById(request.getId())
				
				.orElseThrow(() -> new RuntimeException("Product not found"));

		InventoryEntity inventory = inventoryRepository.findByProduct_Id(product.getId()).orElse(new InventoryEntity());

		inventory.setId(product.getId());
	
		inventory.setAvailableQty(request.getAvailableQty());
		inventory.setStatus(request.getStatus());

		return productRepository.save(inventory);
	}

	@Override
	public InventoryEntity getByProductId(Integer productId) {

		return inventoryRepository.findByProduct_Id(productId)
				.orElseThrow(() -> new RuntimeException("Inventory not found"));
	}

}
