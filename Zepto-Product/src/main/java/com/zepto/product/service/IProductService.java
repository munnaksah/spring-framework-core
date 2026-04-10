package com.zepto.product.service;

import java.util.List;

import org.springframework.ui.Model;

import com.zepto.product.entity.ProductEntity;
import com.zepto.product.request.ProductRequest;
import com.zepto.product.request.ProductResponse;

public interface IProductService {
	public ProductResponse createProduct(ProductRequest  productRequest);
	
	public String checkProductStatus(int productId);
	
	public List<ProductEntity> getAllProducts();
	
	public ProductEntity updateStatus(int id,String status);
	
	public ProductEntity getProductById(int id);

	

	

	
}
