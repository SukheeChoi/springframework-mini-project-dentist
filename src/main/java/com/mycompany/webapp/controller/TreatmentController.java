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

import com.mycompany.webapp.dto.Pager;
import com.mycompany.webapp.dto.Tooth;
import com.mycompany.webapp.dto.Treatment;
import com.mycompany.webapp.service.DeninfoService;
import com.mycompany.webapp.service.ToothService;
import com.mycompany.webapp.service.TreatmentService;

@Controller
@RequestMapping("/treatment")
public class TreatmentController {

	@Resource
	private TreatmentService treatmentService;
	
	@Resource
	private ToothService toothService;
	
	@Resource
	private DeninfoService deninfoService;
	////페이저 추가하기 전체 다 xml부터
	
	@CrossOrigin(origins="*", allowedHeaders = "*")
	@PostMapping(value="/gettreatmentByssn", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String gettreatmentByssn(@RequestParam(defaultValue = "1") int pageNo, String patientssn) {
		/*
		 요청은 이런식 =>
		 http://localhost:8080/springframework-mini-project-dentist/treatment/gettreatmentByssn?patientssn=960422-2222222&pageNo=1
		 응답은 이런식 => 
		*/
		int totalTreatNum = treatmentService.getCountByPatientssn(patientssn);
		Pager pager = new Pager(5, 5, totalTreatNum, pageNo);
		
		List<Treatment> treatments = treatmentService.getTreatmentList(patientssn, pager);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("denname", deninfoService.selectDeninfo().getDenname());
		jsonObject.put("treatment", treatments);
		String json = jsonObject.toString();
		return json;
	}
	
	@CrossOrigin(origins="*", allowedHeaders = "*")
	@PostMapping(value="/gettreatmentBytreatno", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String gettreatmentBytreatno(int treatno) {
		/*
		 요청은 이런식 =>
		 http://localhost:8080/springframework-mini-project-dentist/treatment/gettreatmentBytreatno?treatno=11
		 응답은 이런식 => 
		*/
		Treatment treatment = treatmentService.getTreatment(treatno);
		List<Tooth> tooth = toothService.getTooth(treatno);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("treatno", treatment.getTreatno());
		jsonObject.put("isreviewed", treatment.isIsreviewed());
		jsonObject.put("treattype", treatment.getTreattype());
		jsonObject.put("doctorname", treatment.getDoctorname());
		jsonObject.put("treatcost", treatment.getTreatcost());
		jsonObject.put("treatdate", treatment.getTreatdate());
		jsonObject.put("doctorcomment", treatment.getDoctorcomment());
		jsonObject.put("materialcompany", treatment.getMaterialcompany());
		jsonObject.put("patientssn", treatment.getPatientssn());
		jsonObject.put("tooth", tooth);
		String json = jsonObject.toString();
		return json;
	}
}
