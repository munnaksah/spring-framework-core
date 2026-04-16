package com.apna.product.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.apna.product.request.ProductRequest;
import com.apna.product.request.ProductResponse;

@Service
public interface IProductService {
	

	public ProductResponse createProduct(ProductRequest productRequest);
	

	
	public String checkProductStatus(int Id);



	List<ProductResponse> getAllProducts();
	 
	 
}
