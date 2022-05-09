package com.mycompany.webapp.controller;

import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
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
	
	//치과의 대표 이미지.
	@CrossOrigin(origins="*", allowedHeaders = "*")
	@GetMapping(value="/getDentistImage") //deninfo테이블에 대표 이미지가 있는 경우, 대표 이미지를 전송.
	public void getDentistImage(
			@RequestHeader("User-Agent") String userAgent
			, HttpServletResponse response) throws Exception {//void: 직접 응답을 만들것.
		if(deninfoService.selectDeninfo().getImagefilename() != null) {// 대표이지미가 있는지 조회. 있다면, 전송.
			log.info("실행");
			//DB에서 가져올 정보
			String originalFilename = deninfoService.selectDeninfo().getImagefilename();
//			String saveFilename = boardService.getBoard(boardno).getBimagesavedfilename();
//			String userAgent = (String) model.get("userAgent");
			//응답 내용의 데이터 타입을 응답 헤더에 추가
			response.setContentType(deninfoService.selectDeninfo().getImagecontenttype());
			
			if(userAgent.contains("Trident") || userAgent.contains("MSIE")) {
				//IE 브라우저일 경우
				originalFilename = URLEncoder.encode(originalFilename, "UTF-8");
			} else {
				//크롬, 엣지, 사파리일 경우
				originalFilename = new String(originalFilename.getBytes("UTF-8"), "ISO-8859-1");
			}
			response.setHeader("Content-Disposition", "attachment; filename=\"" + originalFilename + "\"");
			
			//파일 데이터를 응답 본문에 싣기
			File file = new File("/Users/choisukhee/Documents/2022/오스템 임플란트/치과서버/" + originalFilename);
			if(file.exists()) {
				FileCopyUtils.copy(
					new FileInputStream(file)
					, response.getOutputStream()
				);
			}
		}
	}
}
