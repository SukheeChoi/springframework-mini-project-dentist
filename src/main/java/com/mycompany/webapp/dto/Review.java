package com.mycompany.webapp.dto;

import lombok.Data;

@Data
public class Review {
	private String reviewno;
	private String userid;
	private double starscore;
	private String reviewcontent;
	private int lastvisitcount;
}
