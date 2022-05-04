package com.mycompany.webapp.dto;

import java.util.Date;

import lombok.Data;

@Data
public class Reservation {
	private int resno;
	private String patientname;
	private String patientphone;
	private String selecteddate;
//	private Date selecteddate;
	private	String selectedtime; // 희재코멘트: DB칼럼엔 Date타입이던데? 추후 확인 필요
	private boolean isfixed;
	private boolean ispending;
	private boolean isdiscount;
	private String resdesc;
	private String canceldesc;
	private String submitdate;
//	private Date submitdate;
	private String patientssn;
	private String dendomain;
	private String denname;
	
	public Reservation() {
		//DB에서 동적으로 가져와야 함.(IP주소는 고유하지만 변경 가능하기 때문.)
		this.dendomain = "8082";
		this.denname = "광야치과";
	}
	
}
