package com.mycompany.webapp.controller;

import java.util.List;

import javax.annotation.Resource;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mycompany.webapp.dto.Attachment;
import com.mycompany.webapp.service.AttachmentService;
import com.mycompany.webapp.service.TreatmentService;

import lombok.extern.log4j.Log4j2;

@CrossOrigin(origins="*", allowedHeaders = "*")
@Controller
@RequestMapping("/attachment")
@Log4j2
public class AttachmentController {
	// *** DENTIST서버쪽 컨트롤러입니다 ***
	@Resource
	private TreatmentService treatmentService;
	@Resource
	private AttachmentService attachmentService;
	
	@CrossOrigin(origins="*", allowedHeaders = "*")
	@RequestMapping(value="/getAttachmentList", produces="application/json; charset=UTF-8")
	@ResponseBody
	public String getAttachmentList(int treatno) {
		List<Attachment> attachments = attachmentService.getAttachmentList(treatno);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("attachments", attachments);
		String json = jsonObject.toString();
		return json;
	}
}
