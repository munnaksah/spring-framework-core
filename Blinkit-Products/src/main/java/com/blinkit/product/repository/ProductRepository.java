package com.blinkit.product.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.blinkit.product.entity.ProductEntity;

@Repository
public interface ProductRepository  extends CrudRepository<ProductEntity, Integer> {

}
