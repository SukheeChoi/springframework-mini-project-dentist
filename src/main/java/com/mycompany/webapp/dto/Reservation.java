package com.mycompany.webapp.dto;


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

	private String patientssn;
	private String dendomain;
	private String denname;
}
