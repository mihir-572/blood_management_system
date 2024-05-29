package com.blood_bank.Blood_Bank.Controller;
import com.blood_bank.Blood_Bank.Dao.BankInfoDao;
import com.blood_bank.Blood_Bank.Entities.BankDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class UpdateBankBloodController {
	@Autowired
	private BankInfoDao bankInfoDao;
	

	@RequestMapping("bankbloodinfo/updatebloodunit/{id}")
	public String updatebloodinbank(@PathVariable("id") String id,Model model) {
		model.addAttribute("bankidpassed",id);
		model.addAttribute("allattributeofbank",bankInfoDao.getBankdetailsbyId(id));
		return "addbloodinbank";
	}
	
	
	@RequestMapping("BloodRecordInserted")
	public String BloodRecordInserted() {
		  return "BloodRecordInserted";
	}
	
	@RequestMapping("bankbloodinfo/updatebloodunit/addbloodunit/bloodunitupdatedin/{id}")
	   public String BloodRecordInsert(@PathVariable("id") String id) {
		  return "redirect:/bankbloodinfo/{id}";
	  }
	
	@PostMapping("bankbloodinfo/updatebloodunit/addbloodunit/{id}")
	public String updatebloodinbankunit(@PathVariable("id")String id, @ModelAttribute BankDetails bankDetails, Model model) {
		bankInfoDao.insertnewbloodvolume(bankDetails, id);
		model.addAttribute("bbid", id);
		return "BloodRecordInserted";
	}	
	
}






	
	
	