package com.mycompany.webapp.controller;

import java.util.List;

import javax.annotation.Resource;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycompany.webapp.dto.Deninfo;
import com.mycompany.webapp.dto.Treatment;
import com.mycompany.webapp.service.TreatmentService;

@Controller
@RequestMapping("/treatment")
public class TreatmentController {

	@Resource
	private TreatmentService treatmentService;
	////페이저 추가하기 전체 다 xml부터
	@RequestMapping(value="/gettreatmentByssn", produces = "application/json; charset=UTF-8")
	public String gettreatmentByssn(String patientssn) {
		/*
		 요청은 이런식 =>
		 http://localhost:8080/springframework-mini-project-dentist/treatment/gettreatmentByssn?patientssn=960422-2222222
		 응답은 이런식 => 
		*/
		List<Treatment> treatments = treatmentService.getTreatmentList(patientssn);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("treatment", treatments);
		String json = jsonObject.toString();
		return json;
	}
}
