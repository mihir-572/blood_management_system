package com.blood_bank.Blood_Bank.Entities;

import java.time.LocalDate;
import java.time.LocalTime;

public class Event {
	 	private String eventID;
	    private String bankID;
	    private LocalDate date;
	    private LocalTime time;
//	    
	    public Event(){
	    	
	    }
	    
		public Event(String eventID, String bankID, LocalDate date, LocalTime time) {
			super();
			this.eventID = eventID;
			this.bankID = bankID;
			this.date = date;
			this.time = time;
		}
		
		public String getEventID() {
			return eventID;
		}
		public void setEventID(String eventID) {
			this.eventID = eventID;
		}
		public String getBankID() {
			return bankID;
		}
		public void setBankID(String bankID) {
			this.bankID = bankID;
		}
		public LocalDate getDate() {
			return date;
		}
		public void setDate(LocalDate date) {
			this.date = date;
		}
		public LocalTime getTime() {
			return time;
		}
		public void setTime(LocalTime time) {
			this.time = time;
		}
		@Override
		public String toString() {
			return "Event [eventID=" + eventID + ", bankID=" + bankID + ", date=" + date + ", time=" + time + "]";
		}

		
		
		
	    
	    
	
}


