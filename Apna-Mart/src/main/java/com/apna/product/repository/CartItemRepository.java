package com.apna.product.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.apna.product.entity.CartItemEntity;

@Repository
public interface CartItemRepository extends  CrudRepository<CartItemEntity, Integer> {

}
