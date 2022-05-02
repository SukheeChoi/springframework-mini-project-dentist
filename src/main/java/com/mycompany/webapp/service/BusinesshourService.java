package com.mycompany.webapp.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mycompany.webapp.dao.mybatis.BusinesshourDao;
import com.mycompany.webapp.dto.Availablehour;
import com.mycompany.webapp.dto.Businesshour;
import com.mycompany.webapp.dto.Period;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class BusinesshourService {
	
	@Resource
	private BusinesshourDao businesshourDao;
	
	public Businesshour selectByBusinessday(String businessday) {
		return businesshourDao.selectByBusinessday(businessday);
	}
	
	public List<Businesshour> selectAll() {
		return businesshourDao.selectAll();
	}
	
	public void insert(Businesshour businesshour) {
		businesshourDao.insert(businesshour);
	}
	public void update(Businesshour businesshour,Businesshour newbusinesshours) {
		businesshourDao.update(businesshour,newbusinesshours);
	}
	
	
	
}
