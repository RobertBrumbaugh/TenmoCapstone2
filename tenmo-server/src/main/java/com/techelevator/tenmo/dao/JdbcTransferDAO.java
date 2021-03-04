package com.techelevator.tenmo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.tenmo.model.Transfers;

@Component
public class JdbcTransferDAO implements TransferDAO {
	
	private JdbcTemplate jdbcTemplate;
	public JdbcTransferDAO(JdbcTemplate jdbcTemplate) {
	        this.jdbcTemplate = jdbcTemplate;
	    }
	
	private JdbcUserDAO jdbcUserDao;

	@Override
	public List<Transfers> getTransfers(int userId) {
		List<Transfers> list = new ArrayList<>();
		String sql = "SELECT t.transfer_id, t.account_from, t.account_to, amount FROM transfers t " +
				"JOIN accounts a ON a.account_id = t.account_from " +
				//"JOIN users u ON u.user_id = a.user_id " +
				"WHERE a.user_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
		
		while(results.next()) {
			Transfers transfer = mapRowToTransfer(results);
			list.add(transfer);
		}
		return list;
		
	}

	@Override
	public Transfers getTransfersById(int transferId) {
	//	Transfers transfer = new Transfers();
		String sql = "SELECT * FROM transfers t WHERE t.transfer_id = ?";
		Transfers results = jdbcTemplate.queryForObject(sql, Transfers.class, transferId);
		return results;
	}

	@Override
	public String sendTransfer(int accountFrom, int accountTo, double amount) {
		
		if(accountFrom == accountTo) {
			System.out.println("You cannot send money to yourself!");
		}
		//String sql = "INSERT INTO transfers() +  "
		
		return null;
	}

	 private Transfers mapRowToTransfer(SqlRowSet results) {
	        Transfers transfer = new Transfers();
	        transfer.setTransferId(results.getInt("transfer_id"));
	        transfer.setTransferTypeId(results.getInt("transfer_type_id"));
	        transfer.setTransferStatusId(results.getInt("transfer_status_id"));
	        transfer.setAccountFrom(results.getInt("account_from"));
	        transfer.setAccountTo(results.getInt("account_to"));
	        transfer.setAmount(results.getDouble("amount"));
	        return transfer;
	    }
	

}
