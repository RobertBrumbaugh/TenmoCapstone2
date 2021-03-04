package com.techelevator.tenmo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.tenmo.dao.TransferDAO;
import com.techelevator.tenmo.dao.UserDAO;
import com.techelevator.tenmo.model.Transfers;
import com.techelevator.tenmo.model.User;

@RestController
public class TransferController {
	
	private UserDAO userDAO;
	private TransferDAO transferDAO;
	
	public TransferController(TransferDAO transferDAO, UserDAO userDAO) {
		this.transferDAO = transferDAO;
		this.userDAO = userDAO;
	}
	
	@RequestMapping(path = "users", method = RequestMethod.GET)
	public List<User> getUser(){
		List<User> listOfUsers = new ArrayList<>();
		listOfUsers = userDAO.findAll();
		return listOfUsers;
	}
	
	@RequestMapping(path = "accounts/{userId}/transfers", method = RequestMethod.GET)
	public List<Transfers> getAllTransfers(@PathVariable int userId){
		List<Transfers> results = new ArrayList<>();
		results = transferDAO.getTransfers(userId);
		return results;
	}
	
	@RequestMapping(path = "accounts/transfers/{transferId}", method = RequestMethod.GET)
	public Transfers getTransferById(@PathVariable int transferId) {
		Transfers transfer = new Transfers();
		transfer = transferDAO.getTransfersById(transferId);
		return transfer;
	}
	
	@RequestMapping(path = "transfers/{accountTo}", method = RequestMethod.POST)
	public String sendTransfer(int accountFrom, @PathVariable int accountTo, @Valid @RequestBody double amount) {
		String transfer = transferDAO.sendTransfer(accountFrom, accountTo, amount);
		return transfer;
	}

}
