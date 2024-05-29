package com.blood_bank.Blood_Bank.Entities;

public class ContactUs {
	private String contactusID;
    private String name;
    private String query;
    private String emailId;

    public ContactUs(){

    }

   

    public ContactUs(String contactusID, String name, String query, String emailId) {
		super();
		this.contactusID = contactusID;
		this.name = name;
		this.query = query;
		this.emailId = emailId;
	}


    public String getContactusID() {
    	return contactusID;
    }
    
    public void setContactusID(String contactusID) {
    	this.contactusID = contactusID;
    }

	public String getName(){ return name; }

    public void setName(String name){ this.name = name; }

    public String getQuery(){ return query; }

    public void setQuery(String query){ this.query = query; }

    public String getEmailId(){ return emailId; }

    public void setEmailId(String emailId) { this.emailId = emailId; }

}
