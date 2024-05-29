package com.blood_bank.Blood_Bank.Controller;

import com.blood_bank.Blood_Bank.Dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {
	
	@Autowired
	private DonorDao donorDao;
	
	@Autowired
	private RecipientDao recipientDao;
	
	@Autowired 
	private BankInfoDao bankInfoDao;

	@Autowired 
	private EventDao eventDao;

	@Autowired
	private ContactusDao contactusDao;
	

	@Autowired
	private DonorAppointmentDao donorAppointmentDao;
	
	@Autowired
	private RecipientAppointmentDao recipientAppointmentDao;
	
	
	@RequestMapping({"home","/",""})
	public String home() {
		donorDao.createTable();
		recipientDao.createTable();	
		bankInfoDao.createTable();
		eventDao.createTable();
		contactusDao.createContact();
		donorAppointmentDao.createTable();
		recipientAppointmentDao.createTable();
		
		return "home";
	}
}
