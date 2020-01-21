package com.example.consumingrest;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.concurrent.CompletableFuture;
import com.example.consumingrest.*;

@Service
public class QuoteService{

	private static RestTemplate restTemplate;
	
	public QuoteService(RestTemplateBuilder restTemplateBuilder){
		this.restTemplate = restTemplateBuilder.build();
	}
	
	@Async
	public static CompletableFuture<Quote> receiveQuote() throws InterruptedException{
		Quote result = restTemplate.getForObject("https://gturnquist-quoters.cfapps.io/api/random", Quote.class);
		return CompletableFuture.completedFuture(result);
	}

}
