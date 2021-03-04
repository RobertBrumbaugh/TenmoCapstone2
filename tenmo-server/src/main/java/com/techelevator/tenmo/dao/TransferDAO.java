package com.techelevator.tenmo.dao;

import java.util.List;

import com.techelevator.tenmo.model.Transfers;

public interface TransferDAO {

	public List<Transfers> getTransfers(int userId);
	public Transfers getTransfersById(int transferId);
	public String sendTransfer (int accountFrom, int accountTo, double amount );
	
}
