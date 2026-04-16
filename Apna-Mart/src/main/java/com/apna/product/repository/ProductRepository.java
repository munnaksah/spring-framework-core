package com.apna.product.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.apna.product.entity.InventoryEntity;
import com.apna.product.entity.ProductEntity;



@Repository
public interface ProductRepository  extends CrudRepository<ProductEntity, Integer> {

	InventoryEntity save(InventoryEntity inventory);
	Optional<ProductEntity> findById(Integer id);
	   Optional<ProductEntity> findByProductName(String productName);
	   
//	   public List<ProductEntity> getAllProducts();
	   
	   List<ProductEntity> findAll();  // ✅ use this



}
