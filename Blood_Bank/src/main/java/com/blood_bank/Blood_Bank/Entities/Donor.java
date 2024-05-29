package com.blood_bank.Blood_Bank.Entities;

public class Donor {
    private String Fname;
    private String Lname;
    private String userName;
    private String phone;
    private int age;
    private String gender;
    private String bloodGrp;
    private String city;
    private String state;
    private String pincode;

    public Donor() {

    }

	public Donor(String fname, String lname, String userName, String phone, int age, String gender, String bloodGrp,
			String city, String state, String pincode) {
		super();
		Fname = fname;
		Lname = lname;
		this.userName = userName;
		this.phone = phone;
		this.age = age;
		this.gender = gender;
		this.bloodGrp = bloodGrp;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}


	public String getFname() {
        return Fname;
    }
    public void setFname(String fname) {
        Fname = fname;
    }
    public String getLname() {
        return Lname;
    }
    public void setLname(String lname) {
        Lname = lname;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public String getPincode() {
        return pincode;
    }
    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getBloodGrp() {
    	return bloodGrp;
    }
    public void setBloodGrp(String bloodGrp) {
    	this.bloodGrp = bloodGrp;
    }

	@Override
	public String toString() {
		return "Donor [Fname=" + Fname + ", Lname=" + Lname + ", userName=" + userName + ", phone=" + phone + ", age="
				+ age + ", gender=" + gender + ", bloodGrp=" + bloodGrp + ", city=" + city + ", state=" + state
				+ ", pincode=" + pincode + "]";
	}

    
}
