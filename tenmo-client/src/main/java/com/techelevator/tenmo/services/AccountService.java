package com.techelevator.tenmo.services;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import com.techelevator.tenmo.models.Account;
import com.techelevator.tenmo.models.AuthenticatedUser;

public class AccountService {

	public static String AUTH_TOKEN = "";
    private String baseUrl;
    private RestTemplate restTemplate = new RestTemplate();
    private AuthenticatedUser authenticatedUser;

    public AccountService(String url) {
        this.baseUrl = url;
    }
    
   public double getBalance(int userId) {
	   double balance = 0.0;
	   try {
		   balance = restTemplate.exchange(baseUrl + "/accounts/"+ userId +"/balace", HttpMethod.GET, makeAuthEntity(), Double.class).getBody();
	   }catch(RestClientResponseException ex) {
		   System.out.println("Error");
	   }
	   return balance;
   }
   
   private HttpEntity makeAuthEntity() {
	    HttpHeaders headers = new HttpHeaders();
	    headers.setBearerAuth(AUTH_TOKEN);
	    HttpEntity entity = new HttpEntity<>(headers);
	    return entity;
	  }
	
}