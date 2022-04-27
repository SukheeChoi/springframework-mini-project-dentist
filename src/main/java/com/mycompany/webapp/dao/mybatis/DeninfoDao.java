package com.mycompany.webapp.dao.mybatis;

import org.apache.ibatis.annotations.Mapper;

import com.mycompany.webapp.dto.Deninfo;

@Mapper
public interface DeninfoDao {
	public Deninfo selectAll();
	public int insert(Deninfo deninfo); //맨처음 한번 입력이 필요할듯(사실 가정하면 없어도 된다.)
	public int update(Deninfo deninfo); //수정은 필요함!(대신 삭제는 불가능하게)
}
