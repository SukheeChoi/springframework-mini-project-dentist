package com.mycompany.webapp.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mycompany.webapp.dao.mybatis.DeninfoDao;
import com.mycompany.webapp.dto.Deninfo;

@Service
public class DeninfoService {
	
	@Resource
	private DeninfoDao deninfoDao;
	
	public Deninfo selectDeninfo() {
		return deninfoDao.select();
	}
}
