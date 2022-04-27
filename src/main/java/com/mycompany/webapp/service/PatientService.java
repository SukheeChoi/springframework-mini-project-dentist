package com.mycompany.webapp.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mycompany.webapp.dao.mybatis.PatientDao;
import com.mycompany.webapp.dto.Patient;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class PatientService {
	
	@Resource
	private PatientDao patientDao;
	
	//주민번호로 환자 검색하기
	public Patient getPatientsByPatientssn(String patientssn) {
		return patientDao.selectByPatientssn(patientssn);
	}
	
	//이름으로 환자 검색하기
	public List<Patient> getPatientsByPatientName(String patientname) {
		return patientDao.selectByPatientName(patientname);
	}
	
	//전체 환자 검색하기
	public List<Patient> getPatientsAll() {
		return patientDao.selectAll();
	}
	
	//환자 등록하기
	public void createPatient(Patient patient) {
		patientDao.insert(patient);
	}
	
	//환자 정보 수정하기
	public void updatePatient(Patient patient) {
		patientDao.update(patient);
	}
	
	//환자 삭제하기
	public void removePatient(String patientssn) {
		patientDao.deleteByPatientssn(patientssn);
	}
	
}
