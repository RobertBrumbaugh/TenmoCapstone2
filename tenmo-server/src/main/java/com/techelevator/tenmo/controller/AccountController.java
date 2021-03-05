package com.techelevator.tenmo.controller;

import javax.validation.Valid;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.tenmo.dao.AccountDAO;
import com.techelevator.tenmo.dao.UserDAO;

@RestController
public class AccountController {
	

	private UserDAO userDAO;
	private AccountDAO accountDAO;

	public AccountController(AccountDAO accountDAO) {
		this.accountDAO = accountDAO;
	}

	@RequestMapping(path = "accounts/{userId}/balance", method = RequestMethod.GET)
	public Double getBalance(@PathVariable int userId) {
		Double balance = accountDAO.getBalance(userId);
		return balance;
	}
	
	@RequestMapping(path = "accounts/{userId}/updatebalance", method = RequestMethod.PUT)
	public Double addToBalance(@PathVariable int userId, @Valid @RequestBody double amount) {
		Double balance = accountDAO.addToBalance(userId, amount);
		return balance;
	}
	
	@RequestMapping(path = "accounts/{userId}/newbalance", method = RequestMethod.PUT)
	public Double subtractFromBalance(@PathVariable int userId, @Valid @RequestBody double amount) {
		Double balance = accountDAO.subtractFromBalance(userId, amount);
		return balance;
	}
	

	
}
