package com.techelevator.tenmo.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.tenmo.dao.AccountDAO;
import com.techelevator.tenmo.dao.UserDAO;

@RestController
@PreAuthorize("isAuthenticated()")
public class AccountController {
	

	private UserDAO userDAO;
	private AccountDAO accountDAO;

	public AccountController() {
		this.userDAO = userDAO;
		this.accountDAO = accountDAO;
	}

	@RequestMapping(path = "balance/{userId}", method = RequestMethod.GET)
	public Double getBalance(@PathVariable int userId) {
		Double balance = accountDAO.getBalance(userId);
		return balance;
	}
}
