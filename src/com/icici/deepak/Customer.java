package com.icici.deepak;

public class Customer {
	private int acno;
	private String name,pass,addr,mob;
	private int amt;
	public Customer(String name, String pass, String addr, String mob, int amt) {
		super();
		this.name = name;
		this.pass = pass;
		this.addr = addr;
		this.mob = mob;
		this.amt = amt;
	}
	public Customer(int acno,String pass)
	{
		this.acno=acno;
		this.pass=pass;
	}
	
	public Customer() {
		super();
	}
	public int getAcno() {
		return acno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getMob() {
		return mob;
	}
	public void setMob(String mob) {
		this.mob = mob;
	}
	public int getAmt() {
		return amt;
	}
	public void setAmt(int amt) {
		this.amt = amt;
	}
	
	

}
