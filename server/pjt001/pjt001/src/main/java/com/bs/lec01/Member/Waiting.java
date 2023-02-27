package com.bs.lec01.Member;

public class Waiting {
	private int waiting_num=0;
	
	private int hp_num=0;
	private int m_num=0;
	private String name ="";
	private String status ="";
	
	public int getWaiting_num() {
		return waiting_num;
	}
	public void setWaiting_num(int waiting_num) {
		this.waiting_num = waiting_num;
	}
	public int getHp_num() {
		return hp_num;
	}
	public void setHp_num(int hp_num) {
		this.hp_num = hp_num;
	}
	public int getM_num() {
		return m_num;
	}
	public void setM_num(int m_num) {
		this.m_num = m_num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
