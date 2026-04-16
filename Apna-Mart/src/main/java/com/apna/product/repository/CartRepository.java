package com.apna.product.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.apna.product.entity.CartEntity;

@Repository
public interface CartRepository extends CrudRepository<CartEntity, Integer>  {
  
	  Optional<CartEntity> findByUserIdAndStatus(String userId, String status);
}
