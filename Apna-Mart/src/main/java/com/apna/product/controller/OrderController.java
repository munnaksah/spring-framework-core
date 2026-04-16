package com.apna.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.apna.product.entity.OrderEntity;
import com.apna.product.service.IOrderService;

@Controller
public class OrderController {
	@Autowired
	IOrderService iOrderService;
	
	 // ✅ PLACE ORDER
    @PostMapping("/place")
    public OrderEntity placeOrder(@RequestParam String userId) {

        return iOrderService.placeOrder(userId);
    }

}
