package com.blood_bank.Blood_Bank.Controller;

import com.blood_bank.Blood_Bank.Dao.EventDao;
import com.blood_bank.Blood_Bank.Entities.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class addEventController {
	
	@Autowired
	private EventDao eventDao;
	
	@RequestMapping("addevent")
	public String addevent() {
		return "addevent";
	}

	@RequestMapping("eventadded")
	public String eventadded() {
		return "eventadded";
	}

	
	@PostMapping("event/newevent")
	public String submitForm(@ModelAttribute Event event) {
		eventDao.insertEvent(event);
		return "eventadded";
	}
	
	
}

