package com.techelevator.tenmo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.tenmo.model.Transfer;

@Component
public class JdbcTransferDAO implements TransferDAO {
	
	private JdbcTemplate jdbcTemplate;
	public JdbcTransferDAO(JdbcTemplate jdbcTemplate) {
	        this.jdbcTemplate = jdbcTemplate;
	    }
	
	private JdbcUserDAO jdbcUserDao;
	private JdbcAccountDAO jdbcAccountDAO;

	@Override
	public List<Transfer> getTransfers(int userId) {
		List<Transfer> list = new ArrayList<>();
		String sql = "SELECT t.transfer_id, t.account_from, t.account_to, t.amount FROM transfers t " +
				"JOIN accounts a ON a.account_id = t.account_from " +
				"WHERE a.user_id = ?;";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
		
		while(results.next()) {
			Transfer transfer = mapRowToTransfer(results);
			list.add(transfer);
		}
		return list;
		
	}

	@Override
	public Transfer getTransfersById(int transferId) {
		String sql = "SELECT * FROM transfers t WHERE t.transfer_id = ?";
		Transfer results = jdbcTemplate.queryForObject(sql, Transfer.class, transferId);
		return results;
	}

	@Override
	public void createTransfer(Transfer transfer) {
		
		String sql = "INSERT INTO transfers (transfer_type_id, transfer_status_id, account_from, account_to, amount) "
				+ "VALUES (?, ?, ?, ?, ?)";
		
		jdbcTemplate.update(sql, transfer.getTransferTypeId(), transfer.getTransferStatusId(), transfer.getAccountFrom(), transfer.getAccountTo(), transfer.getAmount());
		
	}
    

	 private Transfer mapRowToTransfer(SqlRowSet results) {
	        Transfer transfer = new Transfer();
	        transfer.setTransferId(results.getInt("transfer_id"));
	        transfer.setTransferTypeId(results.getInt("transfer_type_id"));
	        transfer.setTransferStatusId(results.getInt("transfer_status_id"));
	        transfer.setAccountFrom(results.getInt("account_from"));
	        transfer.setAccountTo(results.getInt("account_to"));
	        transfer.setAmount(results.getDouble("amount"));
	        return transfer;
	    }
	

}
