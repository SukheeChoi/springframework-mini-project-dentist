package com.mycompany.webapp.controller;

import java.util.List;

import javax.annotation.Resource;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mycompany.webapp.dto.Pager;
import com.mycompany.webapp.dto.Review;
import com.mycompany.webapp.dto.Treatment;
import com.mycompany.webapp.service.ReviewService;
import com.mycompany.webapp.service.TreatmentService;

import lombok.extern.log4j.Log4j2;

@CrossOrigin
@Controller
@RequestMapping("/review")
@Log4j2
public class ReviewController {
	
	@Resource
	private ReviewService reviewService;
	@Resource
	private TreatmentService treatmentService;
	
	
	@CrossOrigin(origins="*", allowedHeaders = "*")
	@PostMapping(value="/getReviews", produces="application/json; charset=UTF-8")
	@ResponseBody
	public String getReviews(@RequestParam(defaultValue = "1") int pageNo) {
		/*
		 22/05/06 reviewdate 추가
		 요청은 이런식 => getReviews?pageNo=1
		 http://localhost:8082/springframework-mini-project-dentist/review/getReviews?pageNo=1
		 응답은 이런식 =>  "reviewList": [
			        {
			            "lastvisitcount": 500,
			            "reviewno": "500",
			            "reviewcontent": "시험용 후기. 원장님이 친절하세요^^",
			            "userid": "spring",
			            "starscore": 4.5,
			            "reviewdate" : 2022/05/05
			        }, ...
			    ]
			}
		*/
		//리뷰 갯수
		int totalReviewNum = reviewService.getTotalReviewCount();
		
		Pager pager = new Pager(10, 5, totalReviewNum, pageNo);
		//페이지네이션으로 선택된 리뷰 목록
		List<Review> list = reviewService.getReviews(pager);
		
		//평균 별점 정보 가져와서 전달.
		float averageStars = reviewService.getAverageStars();
		
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("averageStars", averageStars);
		jsonObject.put("totalReviewNum", totalReviewNum);
		
		JSONObject jsonObjectPager = new JSONObject();
		jsonObjectPager.put("totalRows", pager.getTotalRows());
		jsonObjectPager.put("totalPageNo", pager.getTotalPageNo());
		jsonObjectPager.put("totalGroupNo", pager.getTotalGroupNo());
		jsonObjectPager.put("startPageNo", pager.getStartPageNo());
		jsonObjectPager.put("endPageNo", pager.getEndPageNo());
		jsonObjectPager.put("pageNo", pager.getPageNo());
		jsonObjectPager.put("pagesPerGroup", pager.getPagesPerGroup());
		jsonObjectPager.put("groupNo", pager.getGroupNo());
		jsonObjectPager.put("rowsPerPage", pager.getRowsPerPage());
		jsonObjectPager.put("startRowNo", pager.getStartRowNo());
		jsonObjectPager.put("startRowIndex", pager.getStartRowIndex());
		jsonObjectPager.put("endRowNo", pager.getEndRowNo());
		jsonObjectPager.put("endRowIndex", pager.getEndRowIndex());
		
		JSONArray jsonArray = new JSONArray();
		jsonArray.put(jsonObjectPager);
		jsonObject.put("pager", jsonArray);
		
		jsonObject.put("reviewList", list);
		
		String json = jsonObject.toString();
		log.info(json);
		return json;
	}
	
	@CrossOrigin(origins="*", allowedHeaders = "*")
	@PostMapping(value="/postReview", produces="application/json; charset=UTF-8")
	@ResponseBody
	public String postReview(@RequestParam String treatno, Review review) {
		log.info("treatno: " + treatno);
		// lastvisitcount 먼저 계산한 뒤 값 set하기
		String reviewWriter = review.getUserid();
		int lastvisitcount = reviewService.getTotalReviewCountByUserid(reviewWriter);
		review.setLastvisitcount(lastvisitcount + 1);
		
		// 리뷰 저장
		log.info("review: " + review);
		int result = reviewService.writeReview(review);
		// 리뷰를 작성한 treatment 대상의 isReviewed 값 업데이트
		Treatment treatment = treatmentService.getTreatment(Integer.parseInt(treatno));
		int modified = treatmentService.modifyTreatmentAsReviewed(treatment);
		log.info("treatment: " + treatment);
		log.info("modified: " + modified);
		
		JSONObject jsonObject = new JSONObject();
		if (result != 1) {
			jsonObject.put("error", "저런! 뭔가 문제가 생겼어요.");
			String json = jsonObject.toString();
			return json;
		}
		jsonObject.put("success", "리뷰를 성공적으로 작성하셨습니다~");
		String json = jsonObject.toString();
		return json;
	}
}
