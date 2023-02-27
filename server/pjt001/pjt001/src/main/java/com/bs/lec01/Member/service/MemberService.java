package com.bs.lec01.Member.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bs.lec01.Member.dao.MemberDao;
import com.bs.lec01.Member.Member;
import com.bs.lec01.Member.Prescription;
import com.bs.lec01.Member.Prescription_drug;
import com.bs.lec01.Member.Waiting;

@Service
public class MemberService implements IMemberService {
	
	@Autowired
	MemberDao dao;
	
	
	 
	@Override
	public int memberRemove(int m_num) {
		
		int result = dao.memberDelete(m_num);
		
		if(result == 0 ) {
			System.out.println("Remove Fail!!");
		} else {
			System.out.println("Remove Success!!");
		}
		
		return result;
	}
	@Override
	public Member memberRegister(Member member) {
		
		return dao.memberInsert(member);
		
}
	
	@Override
	public void memberUpdate(Member member) {
		// TODO Auto-generated method stub
		int update = dao.memberModify(member);
		
	}

	


	@Override
	public List<Member> memberSearch() {
		List<Member> users = new ArrayList<Member>();
		users = dao.MemberSelect();
		
		if (users == null) {
			System.out.println("Login Fail!!");
		} else {
			System.out.println("Login Success!!");
		}
		
		return users;
	}
	@Override
	public HashMap<String,String> issueNumber(int num) {
				return dao.prescriptionissue(num);
	}
	@Override
	public Waiting waitingRegister(Waiting wat) {
		
		
		return dao.waitingInsert(wat);
	}
	@Override
	public List<Waiting> waitingSearch() {

		List<Waiting> wait = new ArrayList<Waiting>();
		wait = dao.waitSelect();
		return wait;
	}
	public int waitingRemove(int num) {
		int result = dao.waitingDelete(num);
		
		if(result == 0 ) {
			System.out.println("Remove Fail!!");
		} else {
			System.out.println("Remove Success!!");
		}
		
		return result;
	}
	@Override
	public int  waitingDefer(int m_num) {
		
	return dao.defer(m_num);
	}
	@Override
	public int waitingm_examination(int m_num) {
		// TODO Auto-generated method stub
		return dao.examination(m_num);
	}
	@Override
	public int waitingwait(int m_num) {
		// TODO Auto-generated method stub
		return dao.waitholdon(m_num);
	}
	
	@Override
	public List<Waiting> deferSearch() {
		List<Waiting> wait = new ArrayList<Waiting>();
		wait = dao.deferSelect();
		return wait;
	}
	@Override
	public void prescriptionsave(Prescription pre) {
		dao.prescriptionsave(pre);
	}

		
	}
	
	

/*@Override
public int prescriptionRemove(Prescription num) {
	
	int result = dao.PrescriptionDelete(num);
	
	if(result == 0 ) {
		System.out.println("Remove Fail!!");
	} else {
		System.out.println("Remove Success!!");
	}
	
	return result;
}*/
/*	public int drugRegister(Prescription_drug drug) {
	int result2 = dao.drugInsert(drug);
	if (result2 == 0) {
		System.out.println("Join Fail!!");
	} else {
		System.out.println("Join Success!!");
	}
	return result2;
}*/