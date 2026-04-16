package com.apna.product.service;

import com.apna.product.entity.OrderEntity;

public interface IOrderService {
	
	
	 OrderEntity placeOrder(String userId);

}
