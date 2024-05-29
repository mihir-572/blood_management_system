package com.blood_bank.Blood_Bank.Entities;

import java.time.LocalDate;
import java.time.LocalTime;

public class DonorAppointment {
	private String appointmentID;
	private String userName;
	private String bankID;
	private LocalDate date;
	private LocalTime time;

	
	
	
	public DonorAppointment() {
	}


	public DonorAppointment(String appointmentID, String userName, String bankID, LocalDate date, LocalTime time) {
		super();
		this.appointmentID = appointmentID;
		this.userName = userName;
		this.bankID = bankID;
		this.date = date;
		this.time = time;

	}
	
	
	public String getAppointmentID() {
		return appointmentID;
	}
	
	public void setAppointmentID(String appointmentID) {
		this.appointmentID = appointmentID;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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


	
	
}

