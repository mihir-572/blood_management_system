package com.blood_bank.Blood_Bank.Controller;

import com.blood_bank.Blood_Bank.Dao.DonorDao;
import com.blood_bank.Blood_Bank.Entities.Donor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DonorController {
	
	@Autowired
    private DonorDao donorDao;
	
	
	@RequestMapping("donor")
	public String donor() {
		  return "donor";
	}
	
	@PostMapping("donor/newdonor")
	public String submitForm(@ModelAttribute Donor donor) {
		donorDao.insertDonor(donor);
		return "redirect:/donorRegistered";
	}
	
}

