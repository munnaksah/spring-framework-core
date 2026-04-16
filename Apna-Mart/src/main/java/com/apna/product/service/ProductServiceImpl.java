package com.apna.product.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apna.product.entity.InventoryEntity;
import com.apna.product.entity.PriceEntity;
import com.apna.product.entity.ProductEntity;
import com.apna.product.repository.ProductRepository;
import com.apna.product.request.ProductRequest;
import com.apna.product.request.ProductResponse;

import jakarta.transaction.Transactional;

@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	ProductRepository productRepository;

	
	@Transactional
	@Override
	public ProductResponse createProduct(ProductRequest productRequest) {

	    // ✅ Extract request data
	    String productName = productRequest.getProductName();
	    String description = productRequest.getDescription();

	    Integer qty = Integer.parseInt(productRequest.getQty());
	    Double priceValue = Double.parseDouble(productRequest.getPrice());

	    String soldBy = productRequest.getSoldBy();

	    System.out.println("Received: " + productName + " " + qty + " " + priceValue);

	    // ✅ Product
	    ProductEntity product = new ProductEntity();
	    product.setProductName(productName);
	    product.setDescription(description);
	    product.setStatus("CREATED");

	    // ✅ Price
	    PriceEntity price = new PriceEntity();
	    price.setPrice(priceValue);
	    price.setCurrencyCode("INR");
	    price.setStatus("ACTIVE");

	    // ✅ Inventory
	    InventoryEntity inventory = new InventoryEntity();
	    inventory.setAvailableQty(qty);
	    inventory.setStatus("AVAILABLE");

	    // 🔗 Set relationships (VERY IMPORTANT)
	    price.setProduct(product);
	    inventory.setProduct(product);

	    product.setPrice(price);
	    product.setInventory(inventory);

	    // ✅ Save product (cascade will save others)
	    ProductEntity saved = productRepository.save(product);

	    // ✅ Response
	    ProductResponse response = new ProductResponse();

	    if (saved != null) {
	        response.setId(saved.getId());
	        response.setConfirmationMSG(" Product created successfully!");
	    } else {
	        response.setConfirmationMSG(" Failed to create product");
	    }

	    return response;
	}
@Transactional
	@Override
	public String checkProductStatus(int id) {
	Optional<ProductEntity> entity = productRepository.findById( id);
	
	if(entity .isPresent()) {
		ProductEntity product = entity.get();
		
		return product.getStatus();
		
	}
	
		
		return"PRODUCT NOT FOUND";
	}
@Override
public List<ProductResponse> getAllProducts() {
	List<ProductEntity> products = productRepository.findAll();

    List<ProductResponse> responseList = new ArrayList<>();

    for (ProductEntity product : products) {

        ProductResponse response = new ProductResponse();

        // basic fields
        response.setId(product.getId());
        
        response.setProductName(product.getProductName());
      
        response.setDescription(product.getDescription());

        // ✅ Price
        if (product.getPrice() != null) {
            response.setPrice(String.valueOf(product.getPrice().getPrice()));
        }

        // ✅ Inventory
        if (product.getInventory() != null) {
            response.setQty(String.valueOf(product.getInventory().getAvailableQty()));
        }

        responseList.add(response);
    }

    return responseList;
}
}
