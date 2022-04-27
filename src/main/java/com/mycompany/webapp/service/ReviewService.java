package com.mycompany.webapp.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mycompany.webapp.dao.mybatis.ReviewDao;
import com.mycompany.webapp.dto.Pager;
import com.mycompany.webapp.dto.Review;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class ReviewService {

	@Resource
	private ReviewDao reviewDao;

	//페이지네이션을 위한 전체 리뷰 갯수
	public int getTotalReviewCount() {
		return reviewDao.count();
	}
	
	//페이지네이션을 위한 user의 전체 리뷰 갯수
	public int getTotalReviewCountByUserid() {
		return reviewDao.count();
	}

	//전체 리뷰 조회
	public List<Review> getReviews(Pager pager) {
		return reviewDao.selectByPage(pager);
	}
	
	//user의 전체 리뷰 조회
	public List<Review> getReviewsByUserid(String userid, Pager pager) {
		return reviewDao.selectByUserid(userid, pager);
	}
	
	//리뷰 작성
	public void writeReview(Review reviews) {
		reviewDao.insert(reviews);
	}
	
	//리뷰 수정
	public void updateReview(Review reviews) {
		reviewDao.update(reviews);
	}
}
