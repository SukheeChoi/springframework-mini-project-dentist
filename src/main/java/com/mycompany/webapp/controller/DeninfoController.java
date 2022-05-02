package com.mycompany.webapp.controller;

import javax.annotation.Resource;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mycompany.webapp.dto.Deninfo;
import com.mycompany.webapp.service.DeninfoService;

import lombok.extern.log4j.Log4j2;

@Controller
//@RestController
@RequestMapping("/deninfo")
@Log4j2
public class DeninfoController {
	
	@Resource
	private DeninfoService deninfoService;
	
	@CrossOrigin(origins="*", allowedHeaders = "*")
	@PostMapping(value="/getdeninfo", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String getDeninfo() {
		/*
		 요청은 이런식 =>
		 dendomain/springframework-mini-project-dentist/deninfo/getdeninfo
		 응답은 이런식 => "deninfo": "Deninfo(denname=광야치과, dencontact=02-1111-2222, denaddress=서울시 송파구 송이로, 
		 imagecontenttype=null, imagefilename=null, denowner=숙희최, denregistno=1010-01-1010)"
		*/
		log.info("실행");
		/*
		 * DENNAME
			DENCONTACT
			DENADDRESS
			IMAGECONTENTTYPE
			IMAGEFILENAME
			DENOWNER
			DENREGISTNO
			DENLONGITUDE
			DENLATITUDE
		*/
		Deninfo deninfo = deninfoService.selectDeninfo();
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("denname", deninfo.getDenname());
		jsonObject.put("dencontact", deninfo.getDencontact());
		jsonObject.put("denaddress", deninfo.getDenaddress());
		jsonObject.put("imagecontenttype", deninfo.getImagecontenttype());
		jsonObject.put("imagefilename", deninfo.getImagefilename());
		jsonObject.put("denowner", deninfo.getDenowner());
		jsonObject.put("denregistno", deninfo.getDenregistno());
		jsonObject.put("denlongitude", deninfo.getDenlongitude());
		jsonObject.put("denlatitude", deninfo.getDenlatitude());
		String json = jsonObject.toString();
		return json;
	}
}
