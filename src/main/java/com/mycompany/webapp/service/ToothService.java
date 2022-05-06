package com.mycompany.webapp.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mycompany.webapp.dao.mybatis.ToothDao;
import com.mycompany.webapp.dto.Tooth;

@Service
public class ToothService {
	
	@Resource
	private ToothDao toothDao;
	
	public List<Tooth> getTooth(int treatno) {
		List<Tooth> tooth = toothDao.selectByTreatno(treatno);
		return tooth;
	}
	
	public List<Tooth> getToothbyPatientssn(String patientssn) {
		List<Tooth> tooth = toothDao.selectByPatientssn(patientssn);
		return tooth;
	}
}
