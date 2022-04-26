package com.mycompany.webapp.dao.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mycompany.webapp.dto.Material;

public interface MaterialDao {
	public List<Material> select(); //프론트에서 임플란트, 크라운, 기타 등등 종류 선택하는 거 보여줄 때 사용(중복 제거)
	public List<Material> selectByTreattype(String treattype); //임플란트면 임플란트 전체 조회, 크라운이면 크라운 전체 조회
	public int insert(Material materials);
	public int update(@Param("materials")Material materials, @Param("newmaterials")Material newmaterials); //어떻게 수정해야 할지 모르겠음?!
	public int delete(Material materials);//삭제를 제조사로만 받을수는 없을 거 같아서 type이랑 제조사 둘 다 받아서 삭제
	
}
