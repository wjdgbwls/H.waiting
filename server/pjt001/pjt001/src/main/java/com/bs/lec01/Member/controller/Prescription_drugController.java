/*package com.bs.lec01.Member.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bs.lec01.Member.Prescription;
import com.bs.lec01.Member.Prescription_drug;

public class Prescription_drugController {


@RequestMapping(value = "test2", method = RequestMethod.POST)
public void  test2(@RequestBody Prescription pre){
	List<Prescription_drug> drug = pre.getDrugs();
	int count = drug.size();
	for(int i=0; i<count; i++) {
		Prescription_drug _d = drug.get(i);
		System.out.println(_d.getDrug_name());
		System.out.println(_d.getDose());
		System.out.println(_d.getDtime());
		
	}@RequestMapping(value = "/test5", method = RequestMethod.POST)
	public Prescription_drug add2(@RequestBody Prescription_drug drug) {
		service.drugRegister(drug);
		return drug;
	}}
}}*/