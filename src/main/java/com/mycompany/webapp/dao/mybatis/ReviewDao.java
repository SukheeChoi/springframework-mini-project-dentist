package com.mycompany.webapp.dao.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.mycompany.webapp.dto.Pager;
import com.mycompany.webapp.dto.Review;

@Mapper
public interface ReviewDao {
	public List<Review> selectByPage(Pager pager);
	public List<Review> selectByUserid(@Param("userid") String userid, @Param("pager") Pager pager);
	public int count();
	public int countByUserid(String userid);
	public int insert(Review reviews);
	public int update(Review reviews);
}
