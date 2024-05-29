package com.blood_bank.Blood_Bank.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppointmentSubmitted {
	@RequestMapping("appointmentsubmitted")
	   public String appointmentsubmitted() {
		  return "appointmentsubmitted";
	  }
}