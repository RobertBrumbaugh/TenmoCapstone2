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

	public AccountController(AccountDAO accountDAO) {
		this.accountDAO = accountDAO;
	}

	@PreAuthorize("permitAll")
	@RequestMapping(path = "/accounts/{id}/balance", method = RequestMethod.GET)
	public Double getBalance(@PathVariable int id) {
		Double balance = accountDAO.getBalance(id);
		return balance;
	}
}
