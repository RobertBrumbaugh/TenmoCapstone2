package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Account;

public interface AccountDAO {
	
	double getBalance(int userId);
	double addToBalance();
	double subtractFromBalance();
	Account searchByUserId(int userId);
	Account searchByAccountId(int accountId);
	

}
