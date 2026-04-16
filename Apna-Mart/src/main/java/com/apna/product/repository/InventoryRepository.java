package com.apna.product.repository;


import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.apna.product.entity.InventoryEntity;

@Repository
public interface InventoryRepository extends CrudRepository<InventoryEntity, Integer>  {

	
    Optional<InventoryEntity> findByProduct_Id(Integer productId);}
