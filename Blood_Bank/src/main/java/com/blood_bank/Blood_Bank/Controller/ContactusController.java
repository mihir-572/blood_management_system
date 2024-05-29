package com.blood_bank.Blood_Bank.Controller;

import com.blood_bank.Blood_Bank.Dao.ContactusDao;
import com.blood_bank.Blood_Bank.Entities.ContactUs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class ContactusController {

	@Autowired
	private ContactusDao contactusDao;

	@RequestMapping("contactus")
	public String contactus() { 
		return "contactus";
		}

	@PostMapping("contactus/newcontactus")
	public String submitForm(@ModelAttribute ContactUs contactUs){
		contactusDao.insertContact(contactUs);
		return "redirect:/contactussubmitted";
	}

}


