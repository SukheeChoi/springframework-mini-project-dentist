package com.mycompany.webapp.dto;

import java.util.Date;

import lombok.Data;

@Data
public class Patient {
	private String patientname;
	private Date patientbirthdate;
	private String patientsex;
	private String patientphone;
	private String patientaddress;
	private String patientssn;
}
