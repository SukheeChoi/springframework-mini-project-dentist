package com.mycompany.webapp.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mycompany.webapp.dao.mybatis.AttachmentDao;
import com.mycompany.webapp.dto.Attachment;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class AttachmentService {
	@Resource
	private AttachmentDao attachmentDao;
	
	public List<Attachment> getAttachmentList(int treatno) {
		List<Attachment> list = attachmentDao.selectByTreatno(treatno);
		return list;
	}
}
