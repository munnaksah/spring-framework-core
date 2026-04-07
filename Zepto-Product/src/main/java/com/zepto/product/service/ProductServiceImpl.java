package com.zepto.product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zepto.product.repository.ProductRepository;
import com.zepto.product.request.ProductRequest;
import com.zepto.product.request.ProductResponse;

// all the business logic here 

@Service
public class ProductServiceImpl implements IProductService {
	
	@Autowired
	ProductRepository  productRepository;

	@Override
	public ProductResponse createProduct(ProductRequest productRequest) {

		String productName = productRequest.getProductName();
		
		String qty = productRequest.getQty();
		
		String description = productRequest.getDescription();
		
		String price = productRequest.getPrice();
		
		String soldBy = productRequest.getSoldBy();

		System.out.println(" ProductServiceImpl ---> Received from seller :" + productName + " " + qty + " " + description + " " + price + " " + soldBy);


		String input= productName+ qty;

	// calling to DAO or calling to Repository
		String 	productId = productRepository.uploadProduct(input);

		ProductResponse productResponse = new ProductResponse();
		
		if(productId != null) {
		productResponse.setProductId(productId);
		productResponse.setConfirmationMSG(
				"🎉ProductServiceImpl---> Success! Your product has been uploaded successfully and will be visible on the catalog after review.");
		}else {
			productResponse.setProductId(productId);
			productResponse.setConfirmationMSG(
					"🎉unable to upload product.");
			
		}
		
		return productResponse;
	}

}
