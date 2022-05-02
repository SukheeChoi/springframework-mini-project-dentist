package com.mycompany.webapp.controller;

import javax.annotation.Resource;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mycompany.webapp.dto.Businesshour;
import com.mycompany.webapp.service.BusinesshourService;

import lombok.extern.log4j.Log4j2;

@Controller
@RequestMapping("/businesshour")
@Log4j2
public class BusinesshourController {
	
	@Resource
	private BusinesshourService businesshourService;
	
	@GetMapping(value="/getHour", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String getHour(String businessday) {
		/*
		 요청은 이런식 => getHour?date=2022/05/06
		 http://localhost:8080/springframework-mini-project-dentist/businesshour/getHour?businessday=2022/05/06
		 응답은 이런식 => {"date", "0000000001111111111100000000000"}
		*/
		Businesshour dbdate = businesshourService.selectByBusinessday(businessday);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("businessday", dbdate.getBusinesshour());
		String json = jsonObject.toString();
		return json;
	}
}
