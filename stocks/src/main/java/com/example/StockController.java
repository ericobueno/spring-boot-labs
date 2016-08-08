package com.example;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StockController {
	
	private static Logger logger = Logger.getLogger(StockController.class);
	
	@Autowired
	StockRepository stockRepository;

	public StockController() {
	}

//	http://localhost:8080/stock?ticker=FDC	
    @RequestMapping(value="/stock", method=RequestMethod.GET)
    public Stock stock(@RequestParam(value="ticker", defaultValue="NFLX") String ticker) {
    	logger.info("Searching..." + ticker);
    	
    	Stock stock = stockRepository.findOne(ticker);
    	if(stock == null){

    	}
    	logger.info("Found: " + stock);
    	return stock;
    }
    
//	Post to http://localhost:8080/stock?ticker=FDC&price=23.50
    @RequestMapping(value="/stock", method=RequestMethod.POST)
    public Stock stock(@RequestParam(value="ticker", defaultValue="NFLX") String ticker,
    		@RequestParam(value="price", defaultValue="100.0") double price) {
    	
    	Stock stock = new Stock(ticker, price);
    	logger.info("Saving...: " + stock );
    	Stock savedStock = stockRepository.save(stock);
    	logger.info("Saved: " + savedStock);
    	return savedStock;
    	
    }
    
//	Post to http://localhost:8080/addstock with contents below in the body
 /*   
 {
    	"ticker": "ATT",
    	"price": 101.23
 }
    
 */
    @RequestMapping(value="/addstock", method=RequestMethod.POST)
    public Stock stock( @RequestBody Stock stock ) {
    	
    	
    	logger.info("Saving...: " + stock );
    	
    	Stock savedStock = stockRepository.save(stock);
    	
    	logger.info("Saved: " + savedStock);
    	
    	return savedStock;
    	
    }
    
    @RequestMapping("/stocks")
    public List<Stock> stocks() {
    	
    	List<Stock> stocks = new ArrayList<>();
    	
    	Iterable<Stock> findAll = stockRepository.findAll();
    	for (Stock stock : findAll)
    	{
    		System.out.println("stock: " + stock);
    		stocks.add(stock);
    	}
    	
    	return stocks;
    	
    }
    
}