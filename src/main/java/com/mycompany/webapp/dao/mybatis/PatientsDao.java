package com.mycompany.webapp.dao.mybatis;

import java.util.List;

import com.mycompany.webapp.dto.Patients;

public interface PatientsDao {
	public Patients selectByPatientssn(String patientssn);
	public List<Patients> selectAll();
	public int insert(Patients patient);
	public int update(Patients patient);
	public int deleteByPatientssn(String patientssn);
	
}
