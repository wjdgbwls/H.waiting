package com.bs.lec01.Member.dao;


import java.util.HashMap;
import java.util.List;

import com.bs.lec01.Member.Member;
import com.bs.lec01.Member.Prescription;
import com.bs.lec01.Member.Prescription_drug;
import com.bs.lec01.Member.Waiting;

public interface IMemberDao {
	Member memberInsert(Member member);
	List<Member> MemberSelect();
	int memberModify(Member member);
	int memberDelete(int num);
	//int memberUpdate(Member member);
	//int drugInsert(Prescription_drug drug);
	//int PrescriptionDelete(Prescription pre);
	Waiting waitingInsert(Waiting wat);
	List<Waiting> waitSelect();
	HashMap<String,String> prescriptionissue(int num);

}