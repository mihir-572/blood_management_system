package com.blood_bank.Blood_Bank.Dao;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.blood_bank.Blood_Bank.Entities.RecipientAppointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;


@Controller
public class RecipientAppointmentDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	 public int createTable() {
	        String query = "CREATE TABLE IF NOT EXISTS recipientappointments (appointmentID VARCHAR(255) PRIMARY KEY,userName VARCHAR(255),bankID VARCHAR(255),bloodGrp VARCHAR(5) NOT NULL, bloodUnit INT NOT NULL,date DATE Not NULL,time TIME NOT NULL ,FOREIGN KEY (userName) REFERENCES recipients(userName) ON DELETE CASCADE,FOREIGN KEY (bankID) REFERENCES allbankdetails(bankID) ON DELETE CASCADE);";
	        return this.jdbcTemplate.update(query);
	    }
	 
	 
	 public List<RecipientAppointment> getAllRecipientAppointment() {
		   String sql = "select * from recipientappointments";
		   List<RecipientAppointment> allrecipientlist = jdbcTemplate.query(sql,new BeanPropertyRowMapper<RecipientAppointment>(RecipientAppointment.class));
		   return allrecipientlist;
	   }
	
	 
	 public void insertRecipientAppointment(RecipientAppointment recipientAppointment) {
		 String sql = "INSERT INTO recipientappointments(appointmentID,userName,bankID,bloodGrp,bloodUnit,date,time) VALUES (?,?,?,?,?,?,?)";
		 jdbcTemplate.update(sql,
				 recipientAppointment.getAppointmentID(),
				 recipientAppointment.getUserName(),
				 recipientAppointment.getBankID(),
				 recipientAppointment.getBloodGrp(),
				 recipientAppointment.getBloodUnit(),
				 recipientAppointment.getDate(),
				 recipientAppointment.getTime()
				 );
	 }
	public void delete(String appointmentID) {
		String sql = "delete from recipientappointments where appointmentID = ? ";
		jdbcTemplate.update(sql, appointmentID);
	}
	public RecipientAppointment get(String appointmentID) {
		String sql = "select * from recipientappointments where appointmentID = ?";
		Object[] args = { appointmentID };
		return jdbcTemplate.queryForObject(sql, args, BeanPropertyRowMapper.newInstance(RecipientAppointment.class));
	}
	public void update(String appointmentID, String userName,String bankID ,String bloodGrp,int bloodUnit,LocalDate date, LocalTime time) {
		jdbcTemplate.update("update recipientappointments set appointmentID=?, userName =?, bankID=? ,bloodGrp=?,bloodUnit=?,date=? ,time=? where appointmentID=? ",appointmentID,userName, bankID,bloodGrp,bloodUnit,date,time, appointmentID);
	}
}	
	
	







