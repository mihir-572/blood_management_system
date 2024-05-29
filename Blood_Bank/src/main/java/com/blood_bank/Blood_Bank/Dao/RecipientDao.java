package com.blood_bank.Blood_Bank.Dao;

import java.util.List;

import com.blood_bank.Blood_Bank.Entities.Recipient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class RecipientDao {
	 @Autowired
	    private JdbcTemplate jdbcTemplate;
	    
	    public RecipientDao(JdbcTemplate jdbcTemplate) {
	        this.jdbcTemplate = jdbcTemplate;
	    }
	    
	    public int createTable() {
	        String query = "CREATE TABLE IF NOT EXISTS recipients (Fname VARCHAR(50) NOT NULL,Lname VARCHAR(50) NOT NULL,userName VARCHAR(50) NOT NULL primary key, phone VARCHAR(15) NOT NULL,age INT NOT NULL,gender varchar(15), city VARCHAR(255) NOT NULL,state VARCHAR(255) NOT NULL,pincode VARCHAR(10) NOT NULL)";
	        return this.jdbcTemplate.update(query);
	    }

	    public void insertRecipient(Recipient recipient) {
	        String sql = "INSERT INTO recipients (Fname,Lname,userName,phone,age,gender,city,state,pincode) VALUES (?,?,?,?,?,?,?,?,?)";
	        jdbcTemplate.update(
	                sql,
	                recipient.getFname(),
	                recipient.getLname(),
	                recipient.getUserName(),
	                recipient.getPhone(),
	                recipient.getAge(),
	                recipient.getGender(),
	                recipient.getCity(),
	                recipient.getState(),
	                recipient.getPincode()
	        );
	    }
	    
	    public List<Recipient> getAllRecipient(){
	    	String sql = "select *from recipients;";
	    	List<Recipient> allrecipients = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Recipient>(Recipient.class));
	    	return allrecipients;
	    }

	
}

