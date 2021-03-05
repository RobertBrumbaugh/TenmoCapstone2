package com.techelevator.tenmo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import com.techelevator.tenmo.models.AuthenticatedUser;
import com.techelevator.tenmo.models.Transfer;
import com.techelevator.tenmo.models.User;

public class TransferService {
	
	public static String AUTH_TOKEN = "";
    private String baseUrl;
    private RestTemplate restTemplate = new RestTemplate();
    private AuthenticatedUser authenticatedUser;

    public TransferService(String url) {
        this.baseUrl = url;
    }
    
	
	  public User[] getUsers(){ 
		User[] listOfUsers = null;
		 
		listOfUsers = restTemplate.exchange(baseUrl + "users", HttpMethod.GET, makeAuthEntity(), User[].class).getBody(); 
	  
  		for(User i : listOfUsers) {
		System.out.println(i.getId() + " " + i.getUsername());

  		}
  		return listOfUsers;
	  }
	  
	  
	  public void sendBucks(int accountToId) {
		  User[] user = null;
		  
		  user = restTemplate.exchange(baseUrl + "transfers/" + accountToId, HttpMethod.GET, makeAuthEntity(), User[].class).getBody();
		  
		  
		  
		  
	  }
	  
//	  public Transfer[] listOfTransfers() {
//	  Transfer listOfTransfers = null;
//	  
//	  listOfTransfers = restTemplate.exchange(baseUrl + "" + authenticatedUser.getUser().getId(), HttpMethod.GET, makeAuthEntity(), Transfer.class).getBody();
//	
//	return null;
//	  
//  }
	  
	  
	  
	  
	 
    
    
    private HttpEntity makeAuthEntity() {
	    HttpHeaders headers = new HttpHeaders();
	    headers.setBearerAuth(AUTH_TOKEN);
	    HttpEntity entity = new HttpEntity<>(headers);
	    return entity;
	  }
    
    

}
