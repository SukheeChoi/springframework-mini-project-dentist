package com.mycompany.webapp.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mycompany.webapp.dao.mybatis.TreatmentDao;
import com.mycompany.webapp.dto.Treatment;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class TreatmentService {
	@Resource
	private TreatmentDao treatmentDao;
	
	public int getCountByPatientssn(String patientssn) {
		return treatmentDao.countByPatientssn(patientssn);
	}
	
	//웹 서버에 진료내역 리스트를 전달하기 위한 select. 조건은 주민번호.
	public List<Treatment> getTreatmentList(String patientssn) {
		List<Treatment> list = treatmentDao.selectByPatientssn(patientssn);
		return list;
	}
	
	//웹 서버에 유저가 선택한 치료종류로만 조회한 진료이력 전달 위한 select.
	public List<Treatment> getTreatmentListByTreatType(String patientssn, String treattype) {
		List<Treatment> list = treatmentDao.selectByTreatType(patientssn, treattype);
		return list;
	}
	
	//웹 서버에서 유저가 선택한 진료내역 1개를 전달하기 위한 select.
	public Treatment getTreatment(int treatno) {
		Treatment treatment = treatmentDao.selectBytreatno(treatno);
		return treatment;
	}
	
	//웹 서버에서 치료내역에 대한 리뷰작성이 완료됐을 때 isReviewed 칼럼값 수정.
	public int modifyTreatmentAsReviewed(Treatment treatment) {
		treatment.setIsreviewed(true);
		return treatmentDao.update(treatment);
	}
	
	//치과 서버에서 진료내역 추가
	public boolean addTreatment(Treatment treatment) {
		int result = treatmentDao.insert(treatment);
		if(result == 1) {
			return true;
		} else {
			return false;			
		}
	}
	
	//치과 서버에서 진료내역 수정
	public boolean modifyTreatment(Treatment treatment) {
		int result = treatmentDao.update(treatment);
		if(result == 1) {
			return true;
		} else {
			return false;			
		}
	}
	
	//치과 서버에서 진료내역 삭제
	public boolean removeTreatment(int treatno) {
		int result = treatmentDao.deleteByTreatno(treatno);
		if(result == 1) {
			return true;
		} else {
			return false;			
		}
	}

	
}
