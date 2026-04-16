package com.apna.product.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.apna.product.entity.PriceEntity;

@Repository
public interface PriceRepository extends CrudRepository<PriceEntity, Integer> {

	List<PriceEntity> findByProductId(Integer productId);

	List<PriceEntity> findByStatus(String status);
}
