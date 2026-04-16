package com.apna.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.apna.product.entity.CartEntity;
import com.apna.product.service.ICartService;

@Controller
public class CartController {
	
	@Autowired
	ICartService iCartService;
	
	
	

    // ✅ ADD TO CART
    @PostMapping("/add")
    public CartEntity addToCart(
            @RequestParam String userId,
            @RequestParam Integer productId,
            @RequestParam Integer quantity) {

        return iCartService.addToCart(userId, productId, quantity);
    }

    // ✅ GET CART
    @GetMapping("/get")
    public CartEntity getCart(@RequestParam Integer userId) {

        return iCartService.getCart(userId);
    }

    // ✅ REMOVE ITEM
    @DeleteMapping("/remove/{cartItemId}")
    public String removeItem(@PathVariable Integer cartItemId) {

    	iCartService.removeItem(cartItemId);
        return "Item removed successfully";
    }

}
