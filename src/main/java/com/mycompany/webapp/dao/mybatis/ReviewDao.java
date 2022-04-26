package com.mycompany.webapp.dao.mybatis;

import java.util.List;

import com.mycompany.webapp.dto.Pager;
import com.mycompany.webapp.dto.Review;

public interface ReviewDao {
	public List<Review> selectByPage(Pager pager);
	public int count();
	public int insert(Review reviews);
	public int update(Review reviews); 		//수정이랑
	public int deleteByReviewno(int reviewno); 	//삭제도 일단 혹시 몰라서 만들어 놓았음.
}
