package com.mycompany.webapp.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mycompany.webapp.dao.mybatis.DeninfoDao;
import com.mycompany.webapp.dao.mybatis.ReservationDao;
import com.mycompany.webapp.dto.Deninfo;
import com.mycompany.webapp.dto.Reservation;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class ReservationService {
	@Resource
	private ReservationDao reservationDao;
	@Resource
	private DeninfoDao deninfoDao;
	
	public List<Reservation> getReservations(String patientssn){
		List<Reservation> list = reservationDao.selectByPatientssn(patientssn);
		Deninfo deninfo = deninfoDao.select();
		for(Reservation res : list) {
			res.setDendomain(deninfo.getDendomain());
			res.setDenname(deninfo.getDenname());
		}
		return list;
	}
	
	public int createReservation(Reservation reservation) {
		int createdRows = reservationDao.insert(reservation);
		log.info("생성된 예약번호: " + reservation.getResno());
		return createdRows;
	}
	//예약변경 불가능!
	public int updateReservation(Reservation reservation) {
		int updatedRows = reservationDao.update(reservation);
		log.info("수정된 예약번호: " + reservation.getResno());
		return updatedRows;
	}
	//예약취소만 가능함!
	public boolean cancelReservation(int resno) {
		boolean result = false;
		int updatedRows = reservationDao.updateForCancel(resno);
		if(updatedRows == 1) {
			result = true;
		}
		log.info("취소된 예약번호: " + resno);
		return result;
	}

	
}
