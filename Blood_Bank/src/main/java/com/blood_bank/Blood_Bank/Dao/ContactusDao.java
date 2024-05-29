package com.blood_bank.Blood_Bank.Dao;

import com.blood_bank.Blood_Bank.Entities.ContactUs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class ContactusDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    public void createContact() {
    	String sql = "Create table if not exists contacts(contactusID varchar(20) primary key NOT NULL, name varchar(20) NOT NULL, query varchar(200)NOT NULL, emailID varchar(40)NOT NULL)";
    	jdbcTemplate.update(sql);
    }

    public void insertContact(ContactUs contactUs){
        String sql = "INSERT INTO contacts (contactusID,name, query, emailId) VALUES (?,?, ?, ?)";
        jdbcTemplate.update(
                sql,
                contactUs.getContactusID(),
                contactUs.getName(),
                contactUs.getQuery(),
                contactUs.getEmailId()
        );
    }
}
