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
	private Date treatedate;
	private String doctorcomment;
	private String materialcompany;
	private String patientssn;
}
