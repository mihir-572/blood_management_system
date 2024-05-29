package com.blood_bank.Blood_Bank.Entities;

public class BankDetails {
    private String bankID;
    private String bankName;
    private String location;
    private int A;
    private int A_;
    private int B;
    private int B_;
    private int O;
    private int O_;
    private int AB;
    private int AB_;
    
    
    public BankDetails() {
		
	}

	public BankDetails(String bankID, String bankName, String location, int a, int a_, int b, int b_, int o, int o_,
			int aB, int aB_) {
		super();
		this.bankID = bankID;
		this.bankName = bankName;
		this.location = location;
		A = a;
		A_ = a_;
		B = b;
		B_ = b_;
		O = o;
		O_ = o_;
		AB = aB;
		AB_ = aB_;
	}
    
	public String getBankID() {
		return bankID;
	}
	public void setBankID(String bankID) {
		this.bankID = bankID;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getA() {
		return A;
	}
	public void setA(int a) {
		A = a;
	}
	public int getA_() {
		return A_;
	}
	public void setA_(int a_) {
		A_ = a_;
	}
	public int getB() {
		return B;
	}
	public void setB(int b) {
		B = b;
	}
	public int getB_() {
		return B_;
	}
	public void setB_(int b_) {
		B_ = b_;
	}
	public int getO() {
		return O;
	}
	public void setO(int o) {
		O = o;
	}
	public int getO_() {
		return O_;
	}
	public void setO_(int o_) {
		O_ = o_;
	}
	public int getAB() {
		return AB;
	}
	public void setAB(int aB) {
		AB = aB;
	}
	public int getAB_() {
		return AB_;
	}
	public void setAB_(int aB_) {
		AB_ = aB_;
	}

	@Override
	public String toString() {
		return "BankDetails [bankID=" + bankID + ", bankName=" + bankName + ", location=" + location + ", A=" + A
				+ ", A_=" + A_ + ", B=" + B + ", B_=" + B_ + ", O=" + O + ", O_=" + O_ + ", AB=" + AB + ", AB_=" + AB_
				+ "]";
	}   
    
}
