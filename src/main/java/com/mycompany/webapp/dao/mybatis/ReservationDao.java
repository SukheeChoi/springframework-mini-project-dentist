package com.mycompany.webapp.dao.mybatis;

import java.util.List;

import com.mycompany.webapp.dto.Pager;
import com.mycompany.webapp.dto.Reservation;

public interface ReservationDao {
	public List<Reservation> selectByUserid(String userid, Pager pager);
	public int insert(Reservation reservation);
	public int update(Reservation reservation);
	public int deleteByResno(int resno);
	
}
