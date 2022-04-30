package com.mycompany.webapp.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mycompany.webapp.dto.Pager;
import com.mycompany.webapp.dto.Review;
import com.mycompany.webapp.service.ReviewService;

import lombok.extern.log4j.Log4j2;

@Controller
@RequestMapping("/review")
@Log4j2
public class ReviewController {
	
	@Resource
	private ReviewService reviewService;
	
	@RequestMapping(value="/getReviews", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String getReviews(@RequestParam(defaultValue = "1") int pageNo, HttpServletResponse response) {
		/*
		 요청은 이런식 => getReviews?pageNo=1
		 http://localhost:8080/springframework-mini-project-dentist/review/getReviews?pageNo=1
		 응답은 이런식 => {"date", "0000000001111111111100000000000"}
		*/
		int totalReviewNum = reviewService.getTotalReviewCount();
		
		Pager pager = new Pager(5, 5, totalReviewNum, pageNo);
		List<Review> reviews = reviewService.getReviews(pager);
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("review", reviews);
		String json = jsonObject.toString();
		return json;
	}
	
}
