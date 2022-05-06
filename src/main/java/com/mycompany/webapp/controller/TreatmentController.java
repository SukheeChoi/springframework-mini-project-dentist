package com.mycompany.webapp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mycompany.webapp.dto.Attachment;
import com.mycompany.webapp.dto.Tooth;
import com.mycompany.webapp.dto.Treatment;
import com.mycompany.webapp.service.AttachmentService;
import com.mycompany.webapp.service.DeninfoService;
import com.mycompany.webapp.service.ToothService;
import com.mycompany.webapp.service.TreatmentService;

import lombok.extern.log4j.Log4j2;



@Controller
@RequestMapping("/treatment")
@Log4j2
public class TreatmentController {
	// *** DENTIST서버쪽 컨트롤러입니다 ***
	@Resource
	private TreatmentService treatmentService;
	@Resource
	private ToothService toothService;
	@Resource
	private AttachmentService attachmentService;
	@Resource
	private DeninfoService deninfoService;
	
	////페이저 추가하기 전체 다 xml부터
	@PostMapping(value="/getTreatmentByssn", produces="application/json; charset=UTF-8")
	@ResponseBody
	public String getTreatmentByssn(String patientssn, @RequestParam(defaultValue = "ALL") String treattype) {
		/*
		 요청은 이런식 =>
		 http://localhost:8081/springframework-mini-project-dentist/treatment/getTreatmentByssn?patientssn=960422-2222222&treattype="임플란트"
		 응답은 이런식 => 
		*/
		List<Treatment> treatments;
		if(treattype.equals("CAVITY")) {
			treattype = "충치 치료";
		} else if (treattype.equals("IMPLANT")) {
			treattype = "임플란트";
		} else if (treattype.equals("NEUROTHERAPY")) {
			treattype = "신경 치료";
		} else if (treattype.equals("EXTRACTION")) {
			treattype = "발치";
		}  else if (treattype.equals("BRACES")) {
			treattype = "교정";
		}
		
		if(treattype.equals("ALL")) {
			treatments = treatmentService.getTreatmentList(patientssn);
		} else {
			treatments = treatmentService.getTreatmentListByTreatType(patientssn, treattype);
		}

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("denname", deninfoService.selectDeninfo().getDenname());
		jsonObject.put("treatment", treatments);
		String json = jsonObject.toString();
		return json;
	}
	
	@CrossOrigin(origins="*", allowedHeaders = "*")
	@PostMapping(value="/getTreatmentBytreatno", produces="application/json; charset=UTF-8")
	@ResponseBody
	public String getTreatmentBytreatno(int treatno) {
		/*
		 요청은 이런식 =>
		 http://localhost:8082/springframework-mini-project-dentist/treatment/getTreatmentBytreatno?treatno=11
		 응답은 이런식 => 
		*/
		Treatment treatment = treatmentService.getTreatment(treatno);
		List<Tooth> teeth = toothService.getTooth(treatno);
		List<Attachment> attachmentList = attachmentService.getAttachmentList(treatno);
		log.info("attachmentList: " + attachmentList);
		
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
		jsonObject.put("teeth", teeth);
		jsonObject.put("attachmentList", attachmentList);
		
		String json = jsonObject.toString();
		
		return json;
	}
	
	@PostMapping(value="/easteregg", produces="application/json; charset=UTF-8")
	@ResponseBody
	public String getEasteregg(@RequestParam String patientssn) {
		List<Treatment> list = treatmentService.getTreatmentList(patientssn);
		
		List<Tooth> toothno = toothService.getToothbyPatientssn(patientssn);

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("list", list);
		jsonObject.put("toothno", toothno);
		String json = jsonObject.toString();
		
		return json;
	}
}