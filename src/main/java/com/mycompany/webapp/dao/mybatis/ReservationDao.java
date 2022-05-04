package com.mycompany.webapp.dao.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.mycompany.webapp.dto.Pager;
import com.mycompany.webapp.dto.Reservation;

@Mapper
public interface ReservationDao {
	public List<Reservation> selectByPatientssn(String patientssn);
	public List<Reservation> selectByPatientssnWithPager(@Param("patientssn") String patientssn, @Param("pager") Pager pager);
	public int insert(Reservation reservation);
	//예약 수정, 취소, 확정.
	public int update(Reservation reservation);
}
