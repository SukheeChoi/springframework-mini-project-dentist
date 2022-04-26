package com.mycompany.webapp.dto;

import java.util.Date;

import lombok.Data;

@Data
public class Reservation {
	private int resno;
	private String patientname;
	private String patientphone;
	private Date selecteddate;
	private String selectedtime;
	private boolean isfixed;
	private boolean ispending;
	private boolean isdiscount;
	private String resdesc;
	private String canceldesc;
	private Date submitdate;
	private String patientssn;
	
}
