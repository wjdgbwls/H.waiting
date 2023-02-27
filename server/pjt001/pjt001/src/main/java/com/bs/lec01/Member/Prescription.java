package com.bs.lec01.Member;

import java.util.List;

public class Prescription {
	private List<Prescription_drug> drugs;
	private String name="";
	private String period="";
	private String img="";
	private String usase="";
	private String citizen_num="";
	private int pre_num=0;
	public int getPre_num() {
		return pre_num;
	}

	private String barcode="";
	private int h_num=0;
	private int n_num=0;


	public int getM_num() {
		return m_num;
	}

	public int getH_num() {
		return h_num;
	}

	public void setH_num(int h_num) {
		this.h_num = h_num;
	}

	public int getN_num() {
		return n_num;
	}

	public void setN_num(int n_num) {
		this.n_num = n_num;
	}

	public void setPre_num(int pre_num) {
		this.pre_num = pre_num;
	}

	public void setM_num(int m_num) {
		this.m_num = m_num;
	}

	private int m_num=0;
	

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getUsase() {
		return usase;
	}

	public void setUsase(String usase) {
		this.usase = usase;
	}

	public String getCitizen_num() {
		return citizen_num;
	}

	public void setCitizen_num(String citizen_num) {
		this.citizen_num = citizen_num;
	}


	public List<Prescription_drug> getDrugs() {
		return drugs;
	}

	public void setDrugs(List<Prescription_drug> drugs) {
		this.drugs = drugs;
	}

	
	}

	