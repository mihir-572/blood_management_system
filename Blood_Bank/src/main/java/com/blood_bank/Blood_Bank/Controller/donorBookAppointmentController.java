package com.blood_bank.Blood_Bank.Controller;

import com.blood_bank.Blood_Bank.Dao.DonorAppointmentDao;
import com.blood_bank.Blood_Bank.Entities.DonorAppointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.ModelAndView;

@Controller
public class donorBookAppointmentController {

	@Autowired
	private DonorAppointmentDao donorAppointmentDao;
	
	@RequestMapping("donorAppointment")
	public String donorAppointment() {
		return "donorAppointment";
	}
	
	@RequestMapping("donorAppointmentSubmitted")
	public String donorAppointmentSubmitted() {
		return "donorAppointmentSubmitted";
	}
		
	@PostMapping("donor/appointment/")
	public String submitForm(@ModelAttribute DonorAppointment donorAppointment) {
		donorAppointmentDao.insertDonorAppointment(donorAppointment);
		return "redirect:/donorAppointmentSubmitted";
	}

	@GetMapping("allDonorAppointments")
	public String allDonorAppointments(Model model) {
		model.addAttribute("alldonorappointments", donorAppointmentDao.getAllDonorAppointment());	
		return "allDonorAppointments";
	}
	
	@RequestMapping("/deleted/{appointmentID}")
	public String delete(@PathVariable("appointmentID") String appointmentID) {
		donorAppointmentDao.delete(appointmentID);
		return "redirect:/allDonorAppointments";
	}

	@RequestMapping("/donorappedit/{appointmentID}")
	public ModelAndView show_edit(@PathVariable("appointmentID") String appointmentID) {
		ModelAndView mav = new ModelAndView();
		DonorAppointment alldonorappointments = donorAppointmentDao.get(appointmentID);
		mav.setViewName("editDonorAppointment");
		mav.addObject("alldonorappointments", alldonorappointments);
		return mav;
	}

	@RequestMapping(value = "/donorappedit/donorapp/update", method = RequestMethod.POST)
	public String edit(@ModelAttribute("object") DonorAppointment object) {
		donorAppointmentDao.update(object.getAppointmentID(), object.getUserName(),object.getBankID(),object.getDate(),object.getTime());
		return "redirect:/allDonorAppointments";
	}
}


	
	
	
	