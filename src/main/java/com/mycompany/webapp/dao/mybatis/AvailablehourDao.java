package com.mycompany.webapp.dao.mybatis;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.mycompany.webapp.dto.Availablehour;
import com.mycompany.webapp.dto.Period;

@Mapper
public interface AvailablehourDao {
	public Availablehour selectBydate(Date date); //하루 치 영업시간 조회
	public List<Availablehour> selectAll(Period period);	//30일치 데이터를 가져올 때 필요할듯?! 아마도 시작날짜만 알면 뒤로 30일 가져올 수 있을 거 같다.
	public int insert(Availablehour availablehours);	//여기도 자동 insert이기 때문에 삭제는 필요없을 듯
	public int update(@Param("availablehours") Availablehour availablehours, @Param("newavailablehours") Availablehour newavailablehours);
}
