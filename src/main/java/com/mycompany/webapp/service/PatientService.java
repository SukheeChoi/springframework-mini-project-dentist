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
	private PatientDao patientdao;
	
	public Patient searchByPatientssn(String patientssn) {
		return patientdao.selectByPatientssn(patientssn);
	}
	
	public List<Patient> searchByPatientName(String patientname) {
		return patientdao.selectByPatientName(patientname);
	}
	
	public List<Patient> searchAll() {
		return patientdao.selectAll();
	}
	
	public void createPatient(Patient patient) {
		patientdao.insert(patient);
	}
	
	public void updatePatient(Patient patient) {
		patientdao.update(patient);
	}
	
	public void removePatient(String patientssn) {
		patientdao.deleteByPatientssn(patientssn);
	}
	
}
