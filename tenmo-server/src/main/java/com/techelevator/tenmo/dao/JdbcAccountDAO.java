package com.techelevator.tenmo.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;

import com.techelevator.tenmo.model.Account;

@Component
public class JdbcAccountDAO implements AccountDAO {

	
	private JdbcTemplate jdbcTemplate;
	public JdbcAccountDAO(JdbcTemplate jdbcTemplate) {
	        this.jdbcTemplate = jdbcTemplate;
	    }

	@Override
	public double getBalance(int userId) {
		double balance = 0.0;
		try {
		String sql = "SELECT balance FROM accounts WHERE user_id = ?;";
		double results = jdbcTemplate.queryForObject(sql, Double.class, userId);
		return results;
	}catch(RestClientException ex) {
		System.out.println("Error");
	}return balance;
	
	}
	

	@Override
	public Double addToBalance(int userId, double amount) {
		String sql = "UPDATE accounts SET balance = (balance + ?) WHERE user_id = ?";
		double balance = jdbcTemplate.update(sql, amount, userId);
		return balance;
	}

	@Override
	public Double subtractFromBalance(int userId, double amount) {
		String sql = "UPDATE accounts SET balance = (balance - ?) WHERE user_id = ?";
		double balance = jdbcTemplate.update(sql, amount, userId);
		return balance;
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
