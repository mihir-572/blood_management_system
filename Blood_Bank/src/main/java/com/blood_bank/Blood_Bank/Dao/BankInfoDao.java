package com.blood_bank.Blood_Bank.Dao;

import com.blood_bank.Blood_Bank.Entities.BankDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BankInfoDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    
    public int createTable() {
        String query = "CREATE TABLE if not exists allbankdetails (bankID varchar(20) PRIMARY KEY Not NULL, bankName VARCHAR(255) Not NULL,location VARCHAR(255) Not NULL,A int default 0,A_ int default 0,B int default 0,B_ int default 0,O int default 0,O_ int default 0,AB int default 0,AB_ int default 0);";
        return this.jdbcTemplate.update(query);
    }
    
    
    public void insertBank(BankDetails bankdetails) {
    	String sql = "insert into allbankdetails values(?,?,?,?,?,?,?,?,?,?,?)";
    	jdbcTemplate.update(sql,
    			bankdetails.getBankID(),
    			bankdetails.getBankName(),
    			bankdetails.getLocation(),
    			0,
    			0,
    			0,
    			0,
    			0,
    			0,
    			0,
    			0
    			);
    }
    
 
    public BankDetails getBankdetailsbyId(String id) {
    	String sql="select *from allbankdetails where bankid=?";
    	return jdbcTemplate.queryForObject(sql, (rs,rowNum)->{
    		return new BankDetails(
    				rs.getString("bankID"),
    				rs.getString("bankName"),
    				rs.getString("location"),
    				rs.getInt("A"),
    				rs.getInt("A_"),
    				rs.getInt("B"),
    				rs.getInt("B_"),
    				rs.getInt("O"),
    				rs.getInt("O_"),
    				rs.getInt("AB"),
    				rs.getInt("AB_"));
    			},id);
    }
    
    public int insertnewbloodvolume(BankDetails bankdetails,String bankid) {
        String query = "update allbankdetails set A=A+?,A_=A_+?,B=B+?,B_=B_+?,O=O+?,O_=O_+?,AB=AB+?,AB_=AB_+? where bankid=?";
        return jdbcTemplate.update(query,
        		bankdetails.getA(),
        		bankdetails.getA_(),
        		bankdetails.getB(),
        		bankdetails.getB_(),
        		bankdetails.getO(),
        		bankdetails.getO_(),
        		bankdetails.getAB(),
        		bankdetails.getAB_(),
        		bankid
        		);
    }
        
    

    public List<BankDetails> getAllBank(){
        String sql = "select *from allbankdetails;";
        List<BankDetails> allBank = jdbcTemplate.query(sql, new BeanPropertyRowMapper<BankDetails>(BankDetails.class));
        return allBank;
    }
	public void delete(String bankID) {
		String sql = "delete from allbankdetails where bankID = ? ";
		jdbcTemplate.update(sql, bankID);
	}
}




