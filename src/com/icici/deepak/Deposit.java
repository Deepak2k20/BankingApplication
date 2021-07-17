package com.icici.deepak;

public class Deposit {
	private int acno;
	private String uname,pass;
	private int d_amt;
	public Deposit(int acno, String uname, String pass,int d_amt) {
		super();
		this.acno = acno;
		this.uname = uname;
		this.pass = pass;
		this.d_amt = d_amt;
	}
	public Deposit() {
		super();
	}
	public int getAcno() {
		return acno;
	}
	public void setAcno(int acno) {
		this.acno = acno;
	}
	public int getD_amt() {
		return d_amt;
	}
	public void setD_amt(int d_amt) {
		this.d_amt = d_amt;
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
