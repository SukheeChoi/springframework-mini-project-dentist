package com.mycompany.webapp.dao.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.mycompany.webapp.dto.Tooth;

@Mapper
public interface ToothDao {
	public List<Tooth> selectByTreatno(int treatno);
	public int insert(Tooth tooth);
	public int update(@Param("tooth") Tooth tooth, @Param("newtooth") Tooth newtooth);
	public int delete(Tooth tooth);	//삭제는 필요없을 거 같은데 일단 만들어 봄.
}
