package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Accounts;

public interface AccountDAO {
	
	double getBalance(int userId);
	double addToBalance();
	double subtractFromBalance();
	Accounts searchByUserId(int userId);
	Accounts searchByAccountId(int accountId);
	

}
