package com.blood_bank.Blood_Bank.Controller;
import com.blood_bank.Blood_Bank.Dao.DonorDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;


@Controller
public class AllDonorController {

		@Autowired 
		private DonorDao donorDao;
		
		
		@Autowired
		JdbcTemplate jdbcTemplate;
		
		@GetMapping("allDonors")
		public String allDonors(Model model) {
			model.addAttribute("alldonors", donorDao.getAllDonor());		
			return "allDonor";
		}
		
		
}





	
	

	