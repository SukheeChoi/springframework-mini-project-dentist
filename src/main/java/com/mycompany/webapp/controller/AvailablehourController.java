package com.mycompany.webapp.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mycompany.webapp.dto.Availablehour;
import com.mycompany.webapp.dto.Reservation;
import com.mycompany.webapp.service.AvailablehourService;
import com.mycompany.webapp.service.DeninfoService;
import com.mycompany.webapp.service.ReservationService;

import lombok.extern.log4j.Log4j2;

@Controller
@RequestMapping("/availablehour")
@Log4j2
public class AvailablehourController {
	
	@Resource
	private AvailablehourService availablehourService;
	@Resource
	private ReservationService reservationService;
	@Resource
	private DeninfoService deninfoService;
	@CrossOrigin(origins="*", allowedHeaders = "*")
	@GetMapping(value="/getHour", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String getHour(Date date) throws Exception {
		/*
		 요청은 이런식 => getHour?date=2022/05/06
		 http://localhost:8080/springframework-mini-project-dentist/availablehour/getHour?date=2022/05/06
		 응답은 이런식 => {"date", "0000000001111111111100000000000"}
		*/
		log.info("date : " + date);
//		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		// 문자열 -> Date
//		Date date2 = formatter.parse(date);
//		log.info("date2 : " + date2);
		Availablehour dbdate = availablehourService.selectBydate(date);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("date", dbdate.getAvailabletime());
		String json = jsonObject.toString();
		return json;
	}
	
	@CrossOrigin(origins="*", allowedHeaders = "*")
	@PostMapping(value="/setHour", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String availableUpdate(Date availabledate,@RequestParam Map<String,Object> param) {
		
		log.info("availableUpdate 실행");
		
		Availablehour availablehour = new Availablehour();
		Reservation reservation = new Reservation();
		availablehour.setAvailabledate(availabledate);
		availablehour.setAvailabletime((String)param.get("availabletime"));
		
		reservation.setPatientname((String)param.get("name"));
		reservation.setPatientphone((String)param.get("phone"));
		//변경 시작~
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		reservation.setSelecteddate(dateFormat.format(availabledate));
//		reservation.setSelecteddate(availabledate);//원래 정민이 코드!!!!!!!!
		//변경 끝~
		reservation.setSelectedtime((String)param.get("tformatDate"));
		reservation.setIsfixed(false);
		reservation.setIspending(true);
		reservation.setIsdiscount(true);
		reservation.setResdesc((String)param.get("reservation"));
		reservation.setCanceldesc((String)param.get("canceldesc"));
		reservation.setPatientssn((String)param.get("patientssn"));
		log.info("availableUpdate 의 reservation" + reservation);

		availablehourService.update(availablehour);

		int result = reservationService.createReservation(reservation);
		JSONObject obj = new JSONObject();
		if(result == 1) {
			obj.put("msg", "hi~");
		} else {
		}

		return obj.toString();
	}
	
}
