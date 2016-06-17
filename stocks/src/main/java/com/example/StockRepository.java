package com.example;

import org.springframework.data.repository.CrudRepository;

public interface StockRepository extends CrudRepository < Stock , String >{
	
//	Stock findOne(String id);
//	@SuppressWarnings("unchecked")
//	Stock save(Stock s);
	
}