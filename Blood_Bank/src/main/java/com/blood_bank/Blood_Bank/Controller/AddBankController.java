package com.blood_bank.Blood_Bank.Controller;

import com.blood_bank.Blood_Bank.Dao.BankInfoDao;
import com.blood_bank.Blood_Bank.Entities.BankDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AddBankController {
	
	@Autowired
	private BankInfoDao bankInfoDao;
	
	@RequestMapping("addbank")
	public String addbank() {
		  return "addbank";
	}
	
	@RequestMapping("bankadded")
	public String bankadded() {
		return "bankadded";
	}
	
	
	@PostMapping("addbank/newbank")
	public String addbank(@ModelAttribute BankDetails bankdetails) {
		bankInfoDao.insertBank(bankdetails);
		return "bankadded";
	}
	
}
