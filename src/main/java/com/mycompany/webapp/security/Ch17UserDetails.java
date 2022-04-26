package com.mycompany.webapp.security;

import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class Ch17UserDetails extends User { // User는 스프링시큐리티가 제공해주는 클래스임
	private String mname;
	private String memail;
//	private Ch14Member member; 뭐 이렇게 해도 되고...
	
	public Ch17UserDetails(
			String mid, 
			String mpassword, 
			boolean menabled, 
			List<GrantedAuthority> mauthorities,
			String mname,
			String memail) {
		super(mid, mpassword, menabled, true, true, true, mauthorities);
		this.memail = memail;
		this.mname = mname;
	}

	public String getMname() {
		return mname;
	}
	
	public String getMemail() {
		return memail;
	}
}

