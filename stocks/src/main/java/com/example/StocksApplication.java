package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StocksApplication {
	
	Logger logger = LoggerFactory.getLogger(StocksApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(StocksApplication.class, args);
	}
	
	@Bean
	CommandLineRunner loadDatabase(StockRepository sr) {
		return args -> {
			
			logger.debug("loading database..");
			
			sr.save(new Stock("ATT", 101.23));
			sr.save(new Stock("FDC", 15.25));
			sr.save(new Stock("MCI", 42.12));
			
			logger.debug("record count: {}", sr.count());
			
			sr.findAll().forEach(x -> logger.debug(x.toString()));
		};

	}

}
