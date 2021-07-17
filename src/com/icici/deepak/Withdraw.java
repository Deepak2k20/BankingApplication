package com.icici.deepak;

public class Withdraw {
	
	private int acno;
	private String uname,pass;
	private int w_amt;
	public Withdraw(int acno, String uname, String pass, int w_amt) {
		super();
		this.acno = acno;
		this.uname = uname;
		this.pass = pass;
		this.w_amt = w_amt;
	}
	public Withdraw() {
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
	public int getW_amt() {
		return w_amt;
	}
	public void setW_amt(int w_amt) {
		this.w_amt = w_amt;
	}
	
	

}
