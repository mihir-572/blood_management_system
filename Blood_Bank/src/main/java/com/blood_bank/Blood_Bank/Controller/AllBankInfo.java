package com.blood_bank.Blood_Bank.Controller;

import com.blood_bank.Blood_Bank.Dao.BankInfoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AllBankInfo {
	@Autowired
    private BankInfoDao bankInfoDao;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	@RequestMapping("viewbankinfo")
	public String viewbankinfo() {
		  return "viewbankinfo";
	}
	
	@GetMapping("allBankInfo")
	public String allBankInfo(Model model) {
		model.addAttribute("allBankInfo", bankInfoDao.getAllBank());		
		return "allBankInfo";
	}	
	
	
	@GetMapping("bankbloodinfo/{id}")
	public String viewbankinfo(@PathVariable("id") String id,Model model) {
		model.addAttribute("bankbloodinfo",bankInfoDao.getBankdetailsbyId(id));
		return "viewbankinfo";
	}

	@RequestMapping("/delete/{bankID}")
	public String delete(@PathVariable("bankID") String bankID) {
		bankInfoDao.delete(bankID);
		return "redirect:/allBankInfo";
	}
	
}

