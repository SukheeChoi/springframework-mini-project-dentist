package com.mycompany.webapp.controller;

import java.util.List;

import javax.annotation.Resource;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@PostMapping(value="/getReviews", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String getReviews(@RequestParam(defaultValue = "1") int pageNo) {
		/*
		 요청은 이런식 => getReviews?pageNo=1
		 http://localhost:8080/springframework-mini-project-dentist/review/getReviews?pageNo=1
		 http://localhost:8080/springframework-mini-project-dentist/review/getReviews?pageNo=2
		 응답은 이런식 =>  "review": [
			        {
			            "lastvisitcount": 500,
			            "reviewno": "500",
			            "reviewcontent": "시험용 후기. 원장님이 친절하세요^^",
			            "userid": "spring",
			            "starscore": 4.5
			        },
			        {
			            "lastvisitcount": 499,
			            "reviewno": "499",
			            "reviewcontent": "시험용 후기. 원장님이 친절하세요^^",
			            "userid": "spring",
			            "starscore": 4.5
			        },
			        {
			            "lastvisitcount": 498,
			            "reviewno": "498",
			            "reviewcontent": "시험용 후기. 원장님이 친절하세요^^",
			            "userid": "spring",
			            "starscore": 4.5
			        },
			        {
			            "lastvisitcount": 497,
			            "reviewno": "497",
			            "reviewcontent": "시험용 후기. 원장님이 친절하세요^^",
			            "userid": "spring",
			            "starscore": 4.5
			        },
			        {
			            "lastvisitcount": 496,
			            "reviewno": "496",
			            "reviewcontent": "시험용 후기. 원장님이 친절하세요^^",
			            "userid": "spring",
			            "starscore": 4.5
			        }
			    ]
			}
		*/
		int totalReviewNum = reviewService.getTotalReviewCount();
		
		Pager pager = new Pager(5, 5, totalReviewNum, pageNo);
		List<Review> reviews = reviewService.getReviews(pager);
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("reviewNum", totalReviewNum);
		jsonObject.put("review", reviews);
		String json = jsonObject.toString();
		return json;
	}
	
}
