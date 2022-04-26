package com.mycompany.webapp.dao.mybatis;

import java.util.Date;
import java.util.List;

import com.mycompany.webapp.dto.Availablehours;

public interface AvailablehoursDao {
	public Availablehours selectBydate(Date date); //하루 치 영업시간 조회
	public List<Availablehours> selectAll();	//30일치 데이터를 가져올 때 필요할듯?!
	public int update(Availablehours availablehours);
	public int insert(Availablehours availablehours);	//여기도 자동 insert이기 때문에 삭제는 필요없을 듯
}
