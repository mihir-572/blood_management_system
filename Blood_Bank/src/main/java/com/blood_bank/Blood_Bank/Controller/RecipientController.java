package com.blood_bank.Blood_Bank.Controller;

import com.blood_bank.Blood_Bank.Dao.RecipientDao;
import com.blood_bank.Blood_Bank.Entities.Recipient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class RecipientController {

	
	@Autowired
    private RecipientDao recipientDao;
	
	
	@RequestMapping("recipient")
	public String recipient() {
		  return "recipient";
	}
	
	@PostMapping("recipient/newrecipient")
	public String submitForm(@ModelAttribute Recipient recipient) {
		recipientDao.insertRecipient(recipient);
		return "redirect:/recipientRegistered";
	}
	
	
}