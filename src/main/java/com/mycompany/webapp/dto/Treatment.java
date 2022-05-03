package com.mycompany.webapp.dto;

import java.util.Date;

import lombok.Data;

@Data
public class Treatment {
	private int treatno;
	private boolean isreviewed;
	private String treattype;
	private String doctorname;
	private int treatcost;
	private Date treatdate;
	private String doctorcomment;
	private String materialcompany;
	private String patientssn;
	private String datestring;
}
