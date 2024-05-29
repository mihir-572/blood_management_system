package com.blood_bank.Blood_Bank.Controller;

import com.blood_bank.Blood_Bank.Dao.EventDao;
import com.blood_bank.Blood_Bank.Entities.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AllEvents {
	
	@Autowired
	public EventDao eventDao;
	
	@GetMapping("allevents")
	public String allevents(Model model) {
		model.addAttribute("allevents", eventDao.getAllEvents());		
		return "allevents";
	}
	
	@RequestMapping("/edit/{eventID}")
	public ModelAndView show_edit(@PathVariable("eventID") String eventID) {
		ModelAndView mav = new ModelAndView();
		Event allevents = eventDao.get(eventID);
		mav.setViewName("editEvents");
		mav.addObject("allevents", allevents);
		return mav;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String edit(@ModelAttribute("object") Event object) {
		eventDao.update(object.getEventID(), object.getBankID(),object.getDate(),object.getTime());
		return "redirect:/allevents";
	}
}


