package com.blood_bank.Blood_Bank.Controller;
import com.blood_bank.Blood_Bank.Dao.RecipientAppointmentDao;
import com.blood_bank.Blood_Bank.Entities.RecipientAppointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.ModelAndView;

@Controller
public class recipientBookAppointmentController {

		@Autowired
		private RecipientAppointmentDao recipientAppointmentDao;
		
		@RequestMapping("recipientAppointment")
		public String recipientAppointment() {
			return "recipientAppointment";
		}
		
		@RequestMapping("recipientAppointmentSubmitted")
		public String donorAppointmentSubmitted() {
			return "donorAppointmentSubmitted";
		}
		
		@PostMapping("recipient/appointment/")
		public String submitForm(@ModelAttribute RecipientAppointment recipientAppointment) {
			recipientAppointmentDao.insertRecipientAppointment(recipientAppointment);
			return "recipientAppointmentSubmitted";
		}
		
		@GetMapping("allRecipientAppointments")
		public String allRecipientAppointments(Model model) {
			model.addAttribute("allrecipientappointments", recipientAppointmentDao.getAllRecipientAppointment());		
			return "allRecipientAppointments";
		}
		
	@RequestMapping("/deletedrecipient/{appointmentID}")
	public String delete(@PathVariable("appointmentID") String appointmentID) {
		recipientAppointmentDao.delete(appointmentID);
		return "redirect:/allRecipientAppointments";
	}
	
	@RequestMapping("/recipientappedit/{appointmentID}")
	public ModelAndView show_edit(@PathVariable("appointmentID") String appointmentID) {
		ModelAndView mav = new ModelAndView();
		RecipientAppointment allRecipient = recipientAppointmentDao.get(appointmentID);
		mav.setViewName("editRecipientAppointment");
		mav.addObject("allrecipientappointments", allRecipient);
		return mav;
	}

	@RequestMapping(value = "/recipientappedit/update", method = RequestMethod.POST)
	public String edit(@ModelAttribute("object") RecipientAppointment object) {
		recipientAppointmentDao.update(object.getAppointmentID(),object.getUserName(), object.getBankID(),object.getBloodGrp(),object.getBloodUnit(),object.getDate(),object.getTime());
		return "redirect:/allRecipientAppointments";
	}
		
}



	
	
	
	