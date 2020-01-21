package com.example.consumingrest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuoteController{
	
	@GetMapping("/")
	public Quote quote() throws Exception{
		try{
			Quote quote = QuoteService.receiveQuote().get();
			Value value = quote.getValue();
			value.setQuote(value.getQuote().toUpperCase());
			quote.setValue(value);
			return quote;
		} catch(Exception e){
			e.printStackTrace();
			return new Quote();
		}
	}
	
}
