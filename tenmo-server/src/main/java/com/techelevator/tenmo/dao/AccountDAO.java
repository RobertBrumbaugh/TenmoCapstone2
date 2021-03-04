package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Account;

public interface AccountDAO {
	
	double getBalance(int userId);
	
	void subtractFromBalance(int userId, double amount);
	
	Account searchByUserId(int userId);
	
	Account searchByAccountId(int accountId);
	
	void addToBalance(int userId, double amount);
	

}
