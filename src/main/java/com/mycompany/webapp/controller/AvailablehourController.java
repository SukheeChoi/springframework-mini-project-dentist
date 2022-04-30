package com.mycompany.webapp.controller;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
	@RequestMapping(value="/getHour", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String getHour(Date date, HttpServletResponse response) {
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
}
