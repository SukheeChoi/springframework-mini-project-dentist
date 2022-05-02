package com.mycompany.webapp.dto;

import lombok.Data;

@Data
public class Attachment {
	private int treatno;
	private String bcontenttype;
	private String boriginalfilename; 
	private String bsavedfilename; 
	private String acontenttype; 
	private String aoriginalfilename; 
	private String asavedfilename; 
}
