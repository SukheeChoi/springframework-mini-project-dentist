package com.mycompany.webapp.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mycompany.webapp.dao.mybatis.AvailablehourDao;
import com.mycompany.webapp.dto.Availablehour;
import com.mycompany.webapp.dto.Period;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class AvailablehourService {
	
	@Resource
	private AvailablehourDao availablehourDao;
	
	public Availablehour selectBydate(Date date) {
		return availablehourDao.selectBydate(date);
	}
	
	public List<Availablehour> selectAll(Period period) {
		return availablehourDao.selectAll(period);
	}
	
	public void insert(Availablehour availablehour) {
		availablehourDao.insert(availablehour);
	}
	public int update(Availablehour availablehour) {
		int updateRows = availablehourDao.update(availablehour);
		return updateRows;
		
	}
	
	
	
}
