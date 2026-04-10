package com.zepto.product.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.zepto.product.entity.ProductEntity;
import com.zepto.product.repository.ProductRepository;
import com.zepto.product.request.ProductRequest;
import com.zepto.product.request.ProductResponse;

// all the business logic here 

@Service
public class ProductServiceImpl implements IProductService {
	
	@Autowired
	ProductRepository  productRepository;

	
	@Transactional
	@Override
	public ProductResponse createProduct(ProductRequest productRequest) {

		String productName = productRequest.getProductName();
		
		String qty = productRequest.getQty();
		
		String description = productRequest.getDescription();
		
		String price = productRequest.getPrice();
		
		String soldBy = productRequest.getSoldBy();

		System.out.println(" ProductServiceImpl ---> Received from seller :" + productName + " " + qty + " " + description + " " + price + " " + soldBy);


		String input= productName+ qty;
		
		String status = "CREATED";

	// calling to DAO or calling to Repository
		String 	productId = productRepository.uploadProduct(input ,status);

		ProductResponse productResponse = new ProductResponse();
		
		if(productId != null) {
		productResponse.setProductId(productId);
		productResponse.setConfirmationMSG(
			    " Product uploaded successfully. It will appear in the catalog soon."
			);
		}else {
			productResponse.setProductId(productId);
			productResponse.setConfirmationMSG(
					"unable to upload product.");
			
		}
		
		return productResponse;
	}

	@Transactional
	@Override
	public String checkProductStatus(int productId) {
	String status =	productRepository.getProductAndCheckStatus(productId);
		return status;
	}

	
	// adding here
	@Transactional
	
	@Override
	public List<ProductEntity> getAllProducts() {
		return productRepository.getAllProducts();
	}

	
	
	
	// for updateData
	
	@Transactional

	@Override
	public ProductEntity updateStatus(int id, String status) {
		productRepository.updateStatus(id, status);
		return productRepository.updateStatus(id, status); 
	}

	@Transactional
	@Override
	public ProductEntity getProductById(int id) {
	    return productRepository.getProductById(id);
	}

	
	

}
