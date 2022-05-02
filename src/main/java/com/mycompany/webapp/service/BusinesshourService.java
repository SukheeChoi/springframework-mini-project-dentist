package com.mycompany.webapp.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mycompany.webapp.dao.mybatis.BusinesshourDao;
import com.mycompany.webapp.dto.Businesshour;

@Service
public class BusinesshourService {
	@Resource
	BusinesshourDao businesshourDao;
	
	public Businesshour getBusinessHourByBusinessday(String businessday) {
		return businesshourDao.selectByBusinessday(businessday);
	}
	
	public List<Businesshour> getAllBusinesshour() {
		return businesshourDao.selectAll();
	}

}
