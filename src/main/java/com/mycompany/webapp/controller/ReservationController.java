package com.mycompany.webapp.controller;

import java.util.List;

import javax.annotation.Resource;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mycompany.webapp.dto.Reservation;
import com.mycompany.webapp.service.ReservationService;

import lombok.extern.log4j.Log4j2;

@Controller
@RequestMapping("/reservation")
@Log4j2
public class ReservationController {
	@Resource
	ReservationService reservationService;
	
	@CrossOrigin(origins="*", allowedHeaders = "*")
	@PostMapping(value="/reservationList", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String getReservationList(@RequestParam String patientssn) {
		//patientssn을 기준으로 reservation객체 list로 받아옴.
		JSONObject jsonObject = new JSONObject();
		List<Reservation> reservationList = reservationService.getReservations(patientssn);
		jsonObject.put("reservationList", reservationList);
		log.info(reservationList.size());
		log.info(reservationList);
		return jsonObject.toString();
	}
}
