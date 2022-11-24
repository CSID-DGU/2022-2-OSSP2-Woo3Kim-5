package com.Woo3Kim.log_inUp;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Account
{
	String id;
	String pw;
	String confirmpw;
	String email;
	String admissionyear;
	String englv;
	float eng;
	String minor;
	
	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getPassword()
	{
		return pw;
	}

	public void setPassword(String password)
	{
		this.pw = password;
	}

	public String getConfirmPassword()
	{
		return confirmpw;
	}

	public void setConfirmPassword(String confirmPassword)
	{
		this.confirmpw = confirmPassword;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getAdmissionYear() {
		return adimissionyear;
	}
	
	public void setAdmissionYear(String year) {
		this.adimissionyear = year;
	}
	
	public String getEngLv() {
		return englv;
	}
	
	public void setEngLv() {
		String elv = "S";
		if(this.eng>=900) {elv=elv+"0";}
		else if(this.eng>=700) {elv=elv+"1";}
		else if(this.eng>=550) {elv=elv+"2";}
		else if(this.eng>=400) {elv=elv+"3";}
		else {elv=elv+"4";}
		this.englv = elv;
	}
	
	public float getEng() {
		return eng;
	}
	
	public void setEng(float e) {
		this.eng = e;
	}
	
	public String getMinor() {
		return minor;
	}
	
	public void setMinor(String m) {
		this.minor = m;
	}
}