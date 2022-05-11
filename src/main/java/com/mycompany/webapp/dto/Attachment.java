package com.mycompany.webapp.dto;

import lombok.Data;

@Data
public class Attachment {
	private int treatno;
	private String contenttype;
	private String originalfilename; 
	private String savedfilename; 
	private boolean isafter; 
}
