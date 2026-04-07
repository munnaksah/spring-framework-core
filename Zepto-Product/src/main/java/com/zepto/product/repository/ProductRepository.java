package com.zepto.product.repository;

import org.springframework.stereotype.Repository;


// it will do interaction b/w Database(CRUD - CREATE , READ,UPDATE,DELETE)

@Repository
public class ProductRepository {
	
	public String uploadProduct(String _input) {
		
		String productId = java.util.UUID.nameUUIDFromBytes(_input.getBytes()).toString().replace("-", "")
				.substring(0, 5).toUpperCase();
		return productId;
	}

	
	

}
