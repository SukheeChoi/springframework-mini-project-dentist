package com.mycompany.webapp.dao.mybatis;

import java.util.List;

import com.mycompany.webapp.dto.Materials;

public interface MaterialsDao {
	public List<Materials> select(); //프론트에서 임플란트, 크라운, 기타 등등 종류 선택하는 거 보여줄 때 사용(중복 제거)
	public List<Materials> selectByTreattype(String treattype); //임플란트면 임플란트 전체 조회, 크라운이면 크라운 전체 조회
	public int insert(Materials materials);
	public int update(Materials materials);
	public int delete(Materials materials);//삭제를 제조사로만 받을수는 없을 거 같아서 type이랑 제조사 둘 다 받아서 삭제
	
}
