package com.apna.product.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.apna.product.entity.CartEntity;
import com.apna.product.entity.CartItemEntity;
import com.apna.product.entity.InventoryEntity;
import com.apna.product.entity.OrderEntity;
import com.apna.product.entity.ProductEntity;
import com.apna.product.repository.CartItemRepository;
import com.apna.product.repository.CartRepository;
import com.apna.product.repository.InventoryRepository;
import com.apna.product.repository.OrderRepository;

import jakarta.transaction.Transactional;

@Service
public class OrderServiceImpl implements IOrderService {

	@Autowired
	CartRepository cartRepository;

	@Autowired
	InventoryRepository inventoryRepository;
	
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	CartItemRepository cartItemRepository;
	
	
	@Transactional
	@Override
	
	public OrderEntity placeOrder(String userId) {

	    // ✅ 1. Get cart
	    CartEntity cart = cartRepository
	            .findByUserIdAndStatus(userId, "ACTIVE")
	            .orElseThrow(() -> new RuntimeException("Cart not found"));

	    // ✅ 2. Correct type
	    List<CartItemEntity> items = cart.getItems();

	    if (items == null || items.isEmpty()) {
	        throw new RuntimeException("Cart is empty");
	    }

	    double total = 0;

	    // ✅ 3. Loop correctly
	    for (CartItemEntity item : items) {

	        // 🔥 Null safety
	        if (item.getProduct() == null) {
	            throw new RuntimeException("Product missing in cart item");
	        }

	        ProductEntity product = item.getProduct();

	        if (product.getPrice() == null) {
	            throw new RuntimeException("Price not available for product: " + product.getProductName());
	        }

	        Double price = product.getPrice().getPrice();
	        Integer qty = item.getQuantity();

	        // 🔥 Inventory check
	        InventoryEntity inventory = product.getInventory();

	        if (inventory == null) {
	            throw new RuntimeException("Inventory not found for product: " + product.getProductName());
	        }

	        if (inventory.getAvailableQty() < qty) {
	            throw new RuntimeException("Out of stock for product: " + product.getProductName());
	        }

	        // ✅ total calculation
	        total += price * qty;

	        // ✅ reduce inventory
	        inventory.setAvailableQty(inventory.getAvailableQty() - qty);
	        inventoryRepository.save(inventory);
	    }

	    // ✅ 4. Create order
	    OrderEntity order = new OrderEntity();
	    order.setUserId(userId);
	    order.setTotalAmount(total);
	    order.setStatus("CREATED");

	    OrderEntity savedOrder = orderRepository.save(order);

	    // ✅ 5. Update cart
	    cart.setStatus("CHECKED_OUT");
	    cartRepository.save(cart);

	    return savedOrder;
	}
	}


