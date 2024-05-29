package com.blood_bank.Blood_Bank.Dao;
import java.util.List;

import com.blood_bank.Blood_Bank.Entities.Donor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;


@Controller
public class DonorDao {
	
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    public DonorDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    public int createTable() {
        String query = "CREATE TABLE IF NOT EXISTS donors (Fname VARCHAR(50) NOT NULL,Lname VARCHAR(50) NOT NULL,userName VARCHAR(50) NOT NULL primary key, phone VARCHAR(15) NOT NULL,age INT NOT NULL,gender varchar(15),bloodGrp VARCHAR(5) NOT NULL,city VARCHAR(255) NOT NULL,state VARCHAR(255) NOT NULL,pincode VARCHAR(10) NOT NULL)";
        return this.jdbcTemplate.update(query);
    }

    public void insertDonor(Donor donor) {
        String sql = "INSERT INTO donors (Fname,Lname,userName,phone,age,gender,bloodGrp,city,state,pincode) VALUES (?,?,?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(
                sql,
                donor.getFname(),
                donor.getLname(),
                donor.getUserName(),
                donor.getPhone(),
                donor.getAge(),
                donor.getGender(),
                donor.getBloodGrp(),
                donor.getCity(),
                donor.getState(),
                donor.getPincode()
        );
    }
    
    public List<Donor> getAllDonor(){
    	String sql = "select *from donors;";
    	List<Donor> alldonors = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Donor>(Donor.class));
    	return alldonors;
    }
    
}
