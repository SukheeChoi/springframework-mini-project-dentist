package com.mycompany.webapp.dao.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.mycompany.webapp.dto.Treatment;

@Mapper
public interface TreatmentDao {
	public List<Treatment> selectByPatientssn(String patientssn); //리스트 전체 출력용, 전체 데이터 조회
	public List<Treatment> selectByTreatType(@Param("patientssn") String patientssn, @Param("treattype") String treattype); //리스트 치료종류로 출력용, 치료종류별 데이터 조회
	public Treatment selectBytreatno(String treatno); //상세화면용 데이터 조회
	public int insert(Treatment treatment);
	public int update(Treatment treatment);
	public int deleteByTreatno(int treatno);
}
