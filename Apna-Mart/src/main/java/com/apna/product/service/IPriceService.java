package com.apna.product.service;

import org.springframework.stereotype.Service;

import com.apna.product.entity.PriceEntity;

@Service
public interface IPriceService {
	
	PriceEntity createPrice(PriceEntity price);
	PriceEntity getPriceById(Integer id);

}
