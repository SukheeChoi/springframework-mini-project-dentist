package com.mycompany.webapp.dao.mybatis;

import java.util.List;

import com.mycompany.webapp.dto.Patient;

public interface PatientDao {
	public Patient selectByPatientssn(String patientssn);
	public List<Patient> selectAll();
	public int insert(Patient patient);
	public int update(Patient patient);
	public int deleteByPatientssn(String patientssn);
	
}
