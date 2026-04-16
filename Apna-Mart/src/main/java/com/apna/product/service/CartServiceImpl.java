package com.apna.product.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apna.product.entity.CartEntity;
import com.apna.product.entity.CartItemEntity;
import com.apna.product.entity.ProductEntity;
import com.apna.product.repository.CartItemRepository;
import com.apna.product.repository.CartRepository;
import com.apna.product.repository.ProductRepository;

@Service
public class CartServiceImpl  implements ICartService{
	@Autowired
	CartRepository cartRepository;
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	CartItemRepository cartItemRepository;
	
	
	@Override
	public CartEntity addToCart(String userId, Integer productId, Integer quantity) {

	    CartEntity cart = cartRepository
	            .findByUserIdAndStatus(userId, "ACTIVE")
	            .orElseGet(() -> {
	                CartEntity newCart = new CartEntity();
	                newCart.setUserId(userId);
	                newCart.setStatus("ACTIVE");
	                return cartRepository.save(newCart);
	            });

	    ProductEntity product = productRepository.findById(productId)
	            .orElseThrow(() -> new RuntimeException("Product not found"));

	    CartItemEntity item = new CartItemEntity();
	    item.setCart(cart);
	    item.setProduct(product);
	    item.setQuantity(quantity);

	    cartItemRepository.save(item);

	    cart.getItems().add(item);

	    return cart;
	}
	@Override
	public CartEntity getCart(Integer userId) {
		
		return null;
	}

	@Override
	public void removeItem(Integer cartItemId) {
	
		
	}
}