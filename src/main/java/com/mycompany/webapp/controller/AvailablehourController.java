package com.mycompany.webapp.controller;

import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mycompany.webapp.dto.Availablehour;
import com.mycompany.webapp.service.AvailablehourService;

import lombok.extern.log4j.Log4j2;

@Controller
@RequestMapping("/availablehour")
@Log4j2
public class AvailablehourController {
	
	@Resource
	private AvailablehourService availablehourService;
	
	@GetMapping(value="/getHour", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String getHour(Date date) {
		/*
		 요청은 이런식 => getHour?date=2022/05/06
		 http://localhost:8080/springframework-mini-project-dentist/availablehour/getHour?date=2022/05/06
		 응답은 이런식 => {"date", "0000000001111111111100000000000"}
		*/
		Availablehour dbdate = availablehourService.selectBydate(date);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("date", dbdate.getAvailabletime());
		String json = jsonObject.toString();
		return json;
	}
	
	
	@PostMapping(value="/setHour", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String availableUpdate(Date availabledate,@RequestParam Map<String,Object> param) {
		Availablehour availablehour = new Availablehour();
		availablehour.setAvailabledate(availabledate);
		availablehour.setAvailabletime((String)param.get("availabletime"));
		log.info(param.get("name"));
		availablehourService.update(availablehour);
		return "/reservation/main";
	}
	
	
}
