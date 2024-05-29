package com.blood_bank.Blood_Bank.Entities;

import java.time.LocalDate;
import java.time.LocalTime;

public class RecipientAppointment {
	private String appointmentID;
	private String userName;
	private String bankID;

	private String bloodGrp;
	private int bloodUnit;
	private LocalDate date;
	private LocalTime time;


	
	
	
	
	public RecipientAppointment() {
	}


	public RecipientAppointment(String appointmentID, String userName, String bankID, String bloodGrp, int bloodUnit, LocalDate date, LocalTime time) {
		this.appointmentID = appointmentID;
		this.userName = userName;
		this.bankID = bankID;
		this.bloodGrp = bloodGrp;
		this.bloodUnit = bloodUnit;
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

	public String getBloodGrp() {
		return bloodGrp;
	}
	public void setBloodGrp(String bloodGrp) {
		this.bloodGrp = bloodGrp;
	}
	public int getBloodUnit() {
		return bloodUnit;
	}
	public void setBloodUnit(int bloodUnit) {
		this.bloodUnit = bloodUnit;
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



