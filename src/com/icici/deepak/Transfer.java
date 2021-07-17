package com.icici.deepak;

public class Transfer {
	private int acno;
	private String uname,pass;
	private int t_acno,t_amt;
	
	
	public Transfer(int acno, String uname, String pass, int t_acno, int t_amt) {
		super();
		this.acno = acno;
		this.uname = uname;
		this.pass = pass;
		this.t_acno = t_acno;
		this.t_amt = t_amt;
	}
	
	public Transfer() {
		super();
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
	public int getT_acno() {
		return t_acno;
	}
	public void setT_acno(int t_acno) {
		this.t_acno = t_acno;
	}
	public int getT_amt() {
		return t_amt;
	}
	public void setT_amt(int t_amt) {
		this.t_amt = t_amt;
	}
	
	

}
