package com.blinkit.product.service;

import com.blinkit.product.request.ProductRequest;
import com.blinkit.product.request.ProductResponse;

public interface IProductService {
	
	public ProductResponse createProduct(ProductRequest productRequest);

	public String checkProductStatus(int productId);

}
