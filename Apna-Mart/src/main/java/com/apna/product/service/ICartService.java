package com.apna.product.service;

import org.springframework.stereotype.Service;

import com.apna.product.entity.CartEntity;

@Service
public interface ICartService {

//	CartEntity addToCart(Integer userId, Integer productId, Integer quantity);

	CartEntity getCart(Integer userId);

	public void removeItem(Integer cartItemId);
	
	public CartEntity addToCart(String userId, Integer productId, Integer quantity);

}
