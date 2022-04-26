package com.mycompany.webapp.dto;

import lombok.Data;

@Data
public class Reviews {
	private String reviewno;
	private int userid;
	private double starscore;
	private String reviewcontent;
	private int lastvisitcount;
}
