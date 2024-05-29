package com.blood_bank.Blood_Bank.Dao;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.blood_bank.Blood_Bank.Entities.DonorAppointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class DonorAppointmentDao {
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	
	 public int createTable() {
	        String query = "CREATE TABLE IF NOT EXISTS donorappointments (appointmentID VARCHAR(255) PRIMARY KEY,userName VARCHAR(255),bankID VARCHAR(255) ,date DATE Not NULL,time TIME NOT NULL ,FOREIGN KEY (userName) REFERENCES donors(userName) ON DELETE CASCADE,FOREIGN KEY (bankID) REFERENCES allbankdetails(bankID) ON DELETE CASCADE);";
	        return this.jdbcTemplate.update(query);
	    }
	 
	 
	 public List<DonorAppointment> getAllDonorAppointment() {
		   String sql = "select * from donorappointments";
		   List<DonorAppointment> alldonorlist = jdbcTemplate.query(sql,new BeanPropertyRowMapper<DonorAppointment>(DonorAppointment.class));
		   return alldonorlist;
	   }
	
	 
	 public void insertDonorAppointment(DonorAppointment donorAppointment) {
		 String sql = "INSERT INTO donorappointments(appointmentID,userName,bankID,date,time) VALUES (?,?,?,?,?)";
		 jdbcTemplate.update(sql,
				 donorAppointment.getAppointmentID(),
				 donorAppointment.getUserName(),
				 donorAppointment.getBankID(),
				 donorAppointment.getDate(),
				 donorAppointment.getTime()
				 );
	 }
	 
	public void delete(String appointmentID) {
		String sql = "delete from donorappointments where appointmentID = ? ";
		jdbcTemplate.update(sql, appointmentID);
	}
	
	public DonorAppointment get(String appointmentID) {
		String sql = "select * from donorappointments where appointmentID = ?";
		Object[] args = { appointmentID };
		return jdbcTemplate.queryForObject(sql, args, BeanPropertyRowMapper.newInstance(DonorAppointment.class));
	}
	
	
	public void update(String appointmentID, String userName, String bankID,LocalDate date, LocalTime time) {
		jdbcTemplate.update("update donorappointments set appointmentID=? ,userName=? , bankID = ?,date=?, time=?  where userName=? ",appointmentID,userName,bankID,date,time, userName);
	}
}







