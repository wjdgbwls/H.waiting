package com.bs.lec01.Member;

import java.io.File;
public class Prescription_drug {

	private String drug_name="";
	private int dose = 0;
	private int dtime = 0;
	private int total_days = 0;
	
	public int getTotal_days() {
		return total_days;
	}
	public void setTotal_days(int total_days) {
		this.total_days = total_days;
	}
	public String getDrug_name()
	{
		return drug_name;
	}
	public void setDrug_name(String drug_name) {
		this.drug_name = drug_name;
	}
	public int getDose() {
		return dose;
	}
	public void setDose(int dose) {
		this.dose = dose;
	}
	public int getDtime() {
		return dtime;
	}
	public void setDtime(int dtime) {
		this.dtime = dtime;
	}
	
}

class MkDir {
    public static void main(String[] args) {
		
	String path = "D:\\Eclipse\\Java\\������"; //���� ���
	File Folder = new File(path);

	// �ش� ���丮�� ������� ���丮�� �����մϴ�.
	if (!Folder.exists()) {
		try{
		    Folder.mkdir(); //���� �����մϴ�.
		    System.out.println("������ �����Ǿ����ϴ�.");
	        } 
	        catch(Exception e){
		    e.getStackTrace();
		}        
         }else {
		System.out.println("�̹� ������ �����Ǿ� �ֽ��ϴ�.");
	}
    }
}
