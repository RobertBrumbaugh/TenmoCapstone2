package com.techelevator.tenmo.services;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
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
	   	double balance = 0.00;
		 balance = restTemplate.exchange(baseUrl + "accounts/"+ userId +"/balance", HttpMethod.GET, makeAuthEntity(), Double.class).getBody();

	   return balance;
   }
   
   public double addToBalance(int userId, double amount) {
	   double balance = 0.00;
	   return balance = restTemplate.exchange(baseUrl + "accounts/"+ userId +"/updatebalance", HttpMethod.PUT, makeAuthEntity(), Double.class).getBody();
   }
   
   public double subtractFromBalance(int userId, double amount) {
	   double balance = 0.00;
	   // new account
	  return balance = restTemplate.exchange(baseUrl + "accounts/"+ userId +"/newbalance", HttpMethod.PUT, makeNewAuthEntity(Account), Double.class).getBody();
	 //  return balance = restTemplate.put(baseUrl + "accounts/"+ userId +"/newbalance", entity);
   
   private HttpEntity makeAuthEntity() {
	    HttpHeaders headers = new HttpHeaders();
	    headers.setBearerAuth(AUTH_TOKEN);
	    HttpEntity entity = new HttpEntity<>(headers);
	    return entity;
	  }
   
   private HttpEntity<Account> makeNewAuthEntity(Account account) {
	   HttpHeaders headers = new HttpHeaders();
	   headers.setContentType(MediaType.APPLICATION_JSON);
	   headers.setBearerAuth(AUTH_TOKEN);
	   HttpEntity<Account> entity = new HttpEntity<>(account, headers);
	   return entity;
   }
	
}