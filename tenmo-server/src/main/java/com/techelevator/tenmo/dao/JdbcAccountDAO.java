package com.techelevator.tenmo.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.tenmo.model.Accounts;

public class JdbcAccountDAO implements AccountDAO {
	
	private JdbcTemplate jdbcTemplate;
	public JdbcAccountDAO(JdbcTemplate jdbcTemplate) {
	        this.jdbcTemplate = jdbcTemplate;
	    }

	@Override
	public double getBalance(int userId) {
		String sql = "SELECT balance FROM accounts WHERE user_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
		
		Double balance = null;
		
		if(results.next()) {
			balance = results.getDouble(userId);
		}
		return balance;
	}

	@Override
	public double addToBalance() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double subtractFromBalance() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Accounts searchByUserId(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Accounts searchByAccountId(int accountId) {
		// TODO Auto-generated method stub
		return null;
	}

}
