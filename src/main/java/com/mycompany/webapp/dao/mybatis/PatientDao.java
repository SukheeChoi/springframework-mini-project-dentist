package com.mycompany.webapp.dao.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mycompany.webapp.dto.Patient;

@Mapper
public interface PatientDao {
	public Patient selectByPatientssn(String patientssn);	//주민번호로 환자 검색
	public List<Patient> selectByPatientName(String patientname);	//이름으로 환자 검색
	public List<Patient> selectAll();	//전체 환자 출력용
	public int insert(Patient patient);
	public int update(Patient patient);
	public int deleteByPatientssn(String patientssn);
	
}
