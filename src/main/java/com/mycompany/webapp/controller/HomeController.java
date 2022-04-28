package com.mycompany.webapp.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycompany.webapp.service.TreatmentService;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
public class HomeController {
	@Resource
	private TreatmentService treatmentService;
	
	@RequestMapping("/")
	public String home() throws Exception {

		return "home"; 
	}
	
	@RequestMapping("/bookAReservation")
	public String bookAReservation() {
		return "/home";
	}

}
