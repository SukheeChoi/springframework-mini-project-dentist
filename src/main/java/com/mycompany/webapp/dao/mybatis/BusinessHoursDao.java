package com.mycompany.webapp.dao.mybatis;

import java.util.List;

import com.mycompany.webapp.dto.Businesshours;

public interface BusinessHoursDao {
	public Businesshours selectByBusinessday(String businessday); //각각 요일에 대한 영업시간 조회
	public List<Businesshours> selectAll(); //전체(월~일) 영업시간 조회
	public int insert(Businesshours businesshours);  //맨처음 입력?! 사실 입력도 필요없을 거 같음
	public int update(Businesshours businesshours);  //무조건 일주일치 유지하기 위해서 update만 있으면 될 듯(그래서 삭제는 일단 안만듬)
}
