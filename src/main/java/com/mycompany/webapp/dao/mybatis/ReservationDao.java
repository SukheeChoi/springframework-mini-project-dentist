package com.mycompany.webapp.dao.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mycompany.webapp.dto.Pager;
import com.mycompany.webapp.dto.Reservation;

public interface ReservationDao {
	public List<Reservation> selectByUserid(@Param("patientssn") String patientssn, @Param("pager") Pager pager);
	public int insert(Reservation reservation);
	//예약 수정, 취소.
	public int update(Reservation reservation);
}
