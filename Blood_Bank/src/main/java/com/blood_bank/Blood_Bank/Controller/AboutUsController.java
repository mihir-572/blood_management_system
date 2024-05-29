package com.blood_bank.Blood_Bank.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class AboutUsController {
	
	@RequestMapping("aboutus")
	   public String aboutus() {
		  return "aboutus";
	  }
}
