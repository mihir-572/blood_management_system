package com.blood_bank.Blood_Bank.Controller;

import com.blood_bank.Blood_Bank.Dao.RecipientDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class AllRecipientController {
	
	@Autowired 
	private RecipientDao recipientDao;
	
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@GetMapping("allRecipients")
	public String allRecipients(Model model) {
		model.addAttribute("allrecipients", recipientDao.getAllRecipient());		
		return "allRecipient";
	}
}

