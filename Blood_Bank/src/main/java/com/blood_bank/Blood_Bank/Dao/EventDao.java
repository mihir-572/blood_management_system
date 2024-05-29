package com.blood_bank.Blood_Bank.Dao;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.blood_bank.Blood_Bank.Entities.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class EventDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	
	
    public int createTable() {
        String query = "CREATE TABLE IF NOT EXISTS allevents(eventID varchar(20) PRIMARY KEY Not NULL,bankID varchar(20)  NULL,date DATE Not NULL,time TIME Not NULL,CONSTRAINT allevents_ibfk_1 FOREIGN KEY (bankID) REFERENCES allbankdetails(bankID) ON DELETE CASCADE)";
        return this.jdbcTemplate.update(query);
    }
	
    public void insertEvent(Event event) {
    	String query = "insert into allevents values (?,?,?,?)";
    	jdbcTemplate.update(
    			query,
    			event.getEventID(),
    			event.getBankID(),
    			event.getDate(),
    			event.getTime()
    			);
    }
	
	public List<Event> getAllEvents(){
		String sql = "select * from allevents;";
		List<Event> allEvent = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Event>(Event.class));
		return allEvent;
	}
	public Event get(String eventID) {
		String sql = "select * from allevents where eventID = ?";
		Object[] args = { eventID };
		return jdbcTemplate.queryForObject(sql, args, BeanPropertyRowMapper.newInstance(Event.class));
	}
	public void update(String eventID, String bankID, LocalDate date, LocalTime time) {
		jdbcTemplate.update("update allevents set bankID=? ,date=? ,time=? where eventID=? ", bankID,date,time, eventID);
	}
}

