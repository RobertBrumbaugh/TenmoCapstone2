package com.techelevator.tenmo.dao;

import java.util.List;

import com.techelevator.tenmo.model.Transfers;

public interface TransferDAO {

	List<Transfers> getTransfers(int userId);
	
	Transfers getTransfersById(int transferId);
	
	String sendTransfer (int accountFrom, int accountTo, double amount );
}
