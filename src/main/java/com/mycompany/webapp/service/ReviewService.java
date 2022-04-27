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

	public int getTotalReviewCount() {
		return reviewDao.count();
	}

	public List<Review> getReviews(Pager pager) {
		return reviewDao.selectByPage(pager);
	}

	public List<Review> getReviewsByUserid(String userid, Pager pager) {
		return reviewDao.selectByUserid(userid, pager);
	}

	public void writeReview(Review reviews) {
		reviewDao.insert(reviews);
	}

	public void updateReview(Review reviews) {
		reviewDao.update(reviews);
	}

	public void removeByReviewno(int reviewno) {
		reviewDao.deleteByReviewno(reviewno);
	}

}
