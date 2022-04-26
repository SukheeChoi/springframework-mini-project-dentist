package com.mycompany.webapp.dao.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mycompany.webapp.dto.Businesshour;

public interface BusinesshourDao {
	public Businesshour selectByBusinessday(String businessday); //각각 요일에 대한 영업시간 조회
	public List<Businesshour> selectAll(); //전체(월~일) 영업시간 조회
	public int insert(Businesshour businesshours);  //맨처음 입력?! 사실 입력도 필요없을 거 같음
	public int update(@Param("businesshours") Businesshour businesshours, @Param("newbusinesshours") Businesshour newbusinesshours);  
	//무조건 일주일치 유지하기 위해서 update만 있으면 될 듯(그래서 삭제는 일단 안만듬)
}
