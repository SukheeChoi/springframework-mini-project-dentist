package com.mycompany.webapp.dao.mybatis;

import java.util.List;

import com.mycompany.webapp.dto.Pager;
import com.mycompany.webapp.dto.Reviews;

public interface ReviewsDao {
	public List<Reviews> selectByPage(Pager pager);
	public int insert(Reviews reviews);
	public int update(Reviews reviews); 		//수정이랑
	public int deleteByReviewno(int reviewno); 	//삭제도 일단 혹시 몰라서 만들어 놓았음.
}
