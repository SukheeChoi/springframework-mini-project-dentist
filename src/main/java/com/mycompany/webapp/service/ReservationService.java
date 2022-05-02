package com.mycompany.webapp.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mycompany.webapp.dao.mybatis.ReservationDao;
import com.mycompany.webapp.dto.Pager;
import com.mycompany.webapp.dto.Reservation;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class ReservationService {
	@Resource
	private ReservationDao reservationDao;
	
	public List<Reservation> getReservations(String patientssn, Pager pager){
		return reservationDao.selectByUserid(patientssn, pager);
	}
	
	public int createReservation(Reservation reservation) {
		int createdRows = reservationDao.insert(reservation);
		log.info("생성된 예약번호: " + reservation.getResno());
		return createdRows;
	}
	
	public int updateReservation(Reservation reservation) {
		int updatedRows = reservationDao.update(reservation);
		log.info("수정된 예약번호: " + reservation.getResno());
		return updatedRows;
	}
}
