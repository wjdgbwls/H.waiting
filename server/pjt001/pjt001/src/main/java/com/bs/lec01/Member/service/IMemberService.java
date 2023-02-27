package com.bs.lec01.Member.service;

import java.util.HashMap;
import java.util.List;

import com.bs.lec01.Member.Member;
import com.bs.lec01.Member.Prescription;
import com.bs.lec01.Member.Prescription_drug;
import com.bs.lec01.Member.Waiting;

public interface IMemberService {
	int memberRemove(int num);
	Member memberRegister(Member member);
	//int drugRegister(Prescription_drug drug);
	List<Member> memberSearch();
	void memberUpdate(Member member);
	Waiting waitingRegister(Waiting wat);
	List<Waiting> waitingSearch();
	int waitingDefer(int m_num);
	int waitingm_examination(int m_num);
	int waitingwait(int m_num);
	List<Waiting> deferSearch();
	void prescriptionsave(Prescription pre);
	HashMap<String,String> issueNumber(int num);
	
	//int prescriptionRemove(Prescription pre);
	//int prescriptionRemove(int num);
}
