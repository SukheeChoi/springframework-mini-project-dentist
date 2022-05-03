package com.mycompany.webapp.controller;

import java.util.List;

import javax.annotation.Resource;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mycompany.webapp.dto.Businesshour;
import com.mycompany.webapp.service.BusinesshourService;

import lombok.extern.log4j.Log4j2;

@Controller
//@RestController
@RequestMapping("/businesshour")
@Log4j2
public class BusinesshourController {

	@Resource
	BusinesshourService businesshourService;
	
	@CrossOrigin(origins="*", allowedHeaders = "*")
	@PostMapping(value="/getBusinessHour", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String getBusinessHour() {
		log.info("제발 푸시하게 해주세요... 제물로 정민이 드림...ㅜ");
		List<Businesshour> list = businesshourService.getAllBusinesshour();
		JSONObject outterJsonObject = new JSONObject();
		for(int i=0; i<list.size(); i++) {
			JSONObject jsonObject = new JSONObject();
			JSONArray innerJsonArray = new JSONArray();
			innerJsonArray.put(list.get(i).getBusinessday() );
			innerJsonArray.put(list.get(i).getBusinesshour() );
			outterJsonObject.put(String.valueOf(i), innerJsonArray);
		}
		// 7개의 objectarray가 담겨있음.
		String strJson = outterJsonObject.toString();
		log.info(strJson);
		return strJson;
	}
	@CrossOrigin(origins="*", allowedHeaders = "*")
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
