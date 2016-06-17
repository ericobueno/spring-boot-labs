package com.example;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import javax.persistence.Id;

@Entity
public class Stock {
	
	@Id
	private String ticker;
	private Double price;

	public Stock() {
		// TODO Auto-generated constructor stub
	}

	public Stock(String ticker, Double price) {
		super();
		this.ticker = ticker;
		this.price = price;
	}

	public String getTicker() {
		return ticker;
	}

	public void setTicker(String ticker) {
		this.ticker = ticker;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Stock [ticker=" + ticker + ", price=" + price + "]";
	}

}
