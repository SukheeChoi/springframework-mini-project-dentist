package com.mycompany.webapp.dao.mybatis;

import java.util.List;

import com.mycompany.webapp.dto.Tooth;

public interface ToothDao {
	public List<Tooth> selectByTreatno();
	public int insert(Tooth tooth);
	public int update(Tooth tooth);
	public int delete(Tooth tooth);	//삭제는 필요없을 거 같은데 일단 만들어 봄.
}
