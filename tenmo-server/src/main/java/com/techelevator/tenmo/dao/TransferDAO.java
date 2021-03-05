package com.techelevator.tenmo.dao;

import java.util.List;

import com.techelevator.tenmo.model.Transfers;

public interface TransferDAO {

	List<Transfers> getTransfers(int userId);
	
	Transfers getTransfersById(int transferId);
	
	Integer sendTransfer (int transferTypeId, int transferStatusId, int accountFrom, int accountTo, double amount );
}
