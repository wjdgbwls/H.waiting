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
		
	String path = "D:\\Eclipse\\Java\\새폴더"; //폴더 경로
	File Folder = new File(path);

	// 해당 디렉토리가 없을경우 디렉토리를 생성합니다.
	if (!Folder.exists()) {
		try{
		    Folder.mkdir(); //폴더 생성합니다.
		    System.out.println("폴더가 생성되었습니다.");
	        } 
	        catch(Exception e){
		    e.getStackTrace();
		}        
         }else {
		System.out.println("이미 폴더가 생성되어 있습니다.");
	}
    }
}
