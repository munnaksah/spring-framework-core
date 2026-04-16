package com.apna.product.repository;

import org.springframework.data.repository.CrudRepository;

import com.apna.product.entity.OrderEntity;

public interface OrderRepository extends CrudRepository<OrderEntity, Integer> {

}
