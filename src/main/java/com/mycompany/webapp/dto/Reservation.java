package com.mycompany.webapp.dto;

import java.util.Date;

import lombok.Data;

@Data
public class Reservation {
	private int resno;
	private String patientname;
	private String patientphone;
	private Date selecteddate;
	private String selectedtime; // 희재코멘트: DB칼럼엔 Date타입이던데? 추후 확인 필요
	private boolean isfixed;
	private boolean ispending;
	private boolean isdiscount;
	private String resdesc;
	private String canceldesc;
	private Date submitdate;
	private String patientssn;
	
}
