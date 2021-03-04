package com.techelevator.tenmo.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.techelevator.tenmo.model.Account;

@Component
public class JdbcAccountDAO implements AccountDAO {

	
	private JdbcTemplate jdbcTemplate;
	public JdbcAccountDAO(JdbcTemplate jdbcTemplate) {
	        this.jdbcTemplate = new JdbcTemplate();
	    }

	@Override
	public double getBalance(int userId) {
		String sql = "SELECT balance FROM accounts WHERE user_id = ?";
		double results = jdbcTemplate.queryForObject(sql, double.class, userId);
		
		return results;
	}
	
//	@Override
//	public double getBalance(int userId) {
//		String sql = 
//	}

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
	public Account searchByUserId(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account searchByAccountId(int accountId) {
		// TODO Auto-generated method stub
		return null;
	}

}
