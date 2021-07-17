package com.icici.deepak;

public class Details {
	private int acno;
	private String uname,pass;
	public Details(int acno, String uname, String pass) {
		super();
		this.acno = acno;
		this.uname = uname;
		this.pass = pass;
	}
	
	public Details() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getAcno() {
		return acno;
	}
	public void setAcno(int acno) {
		this.acno = acno;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	

}
