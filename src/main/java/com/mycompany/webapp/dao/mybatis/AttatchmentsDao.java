package com.mycompany.webapp.dao.mybatis;

import java.util.List;

import com.mycompany.webapp.dto.Attachments;

public interface AttatchmentsDao {
	public List<Attachments> selectBytreatno(int treatno);
	public int insert(Attachments attachment);
	public int update(Attachments attachment);
	public int deleteBybsavedfilename(String bsavedfilename); //무엇을 기준으로 삭제해야할지 모르겠음?!(일단 bsavedfilename)
}
