package com.apna.product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import com.apna.product.entity.PriceEntity;
import com.apna.product.repository.PriceRepository;

@Service
public class PriceServiceImpl implements IPriceService {
	
	@Autowired
	PriceRepository priceRepository;

	@Override
	public PriceEntity createPrice(PriceEntity price) {
		
		price.setStatus("ACTIVE");
		PriceEntity saved =	priceRepository.save(price);
		System.out.println("Saved Price Id"+ saved.getId() );
		
		
		
		
		return saved;
	}

	
	@Override
	public PriceEntity getPriceById(Integer id) {

	    return priceRepository.findById(id)
	            .orElseThrow(() -> new RuntimeException("Price not found with id: " + id));
	}

}
