package com.bs.lec01.Member.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bs.lec01.Member.Member;
import com.bs.lec01.Member.Prescription;
import com.bs.lec01.Member.Waiting;
import com.bs.lec01.Member.service.MemberService;

@RestController

public class MemberController {

	@Autowired
	MemberService service;

	@RequestMapping(value = "/member", method = RequestMethod.PUT) // 환자 정보 수정하기
	public Member Update(@RequestBody Member member) {
		System.out.println("수정하기");
		service.memberUpdate(member);
		return member;
	}

	@GetMapping(value = "/member") // 환자 정보 리스트 리스트로 송출
	public List test() {
		System.out.println("접속 성공");

		return service.memberSearch();
	}

	@RequestMapping(value = "/prescription", method = RequestMethod.GET) // 처방전 발급번호 리턴하기
	public HashMap<String, String> issueNumber(@RequestParam("num") int num) {

		return (service.issueNumber(num));
	}

	@RequestMapping(value = "/prescription", method = RequestMethod.POST) // 처방전 추가하기
	public String prescription(@RequestBody Prescription pre) {

		service.prescriptionsave(pre);
		String pre_num = Integer.toString(pre.getPre_num());

		byte[] imgBytes = Base64.getDecoder().decode(pre.getImg());
		byte[] imgBytes1 = Base64.getDecoder().decode(pre.getBarcode());
		File file = new File("/home/zz/html/patient/" + pre.getM_num() + "/prescription/" + pre.getPre_num() + ".png"); // 경로
		// 설정하기
		File file1 = new File("/home/zz/html/patient/" + pre.getM_num() + "/barcode/B" + pre.getPre_num() + ".png"); // 바코드
		// 경로
		// 설정하기
		file.getParentFile().mkdirs();
		file1.getParentFile().mkdirs();

		System.out.println(file.getAbsolutePath());

		try (FileOutputStream fileOutputStream = new FileOutputStream(file)) {
			fileOutputStream.write(imgBytes);
			fileOutputStream.close();
			FileOutputStream fileOutputStream1 = new FileOutputStream(file1);
			fileOutputStream1.write(imgBytes1);
			fileOutputStream1.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("그림 생성실패");

		}

		return "Success";
	}

	@RequestMapping(value = "/member", method = RequestMethod.DELETE) // 환자 정보 삭제하기

	public void memremove(@RequestParam("num") int num) {

		service.memberRemove(num);
		System.out.println("remove 접속 성공");

	}

	@RequestMapping(value = "/member", method = RequestMethod.POST) // 환자 정보 추가하기
	public Member add(@RequestBody Member member) {

		return service.memberRegister(member);
	}

	@RequestMapping(value = "/waiting", method = RequestMethod.POST)
	public Waiting waiting(@RequestBody Waiting wat) {
		return service.waitingRegister(wat);

	}

	@RequestMapping(value = "/waiting", method = RequestMethod.GET)
	public List test1() {
		System.out.println("접속 성공");

		return service.waitingSearch();
	}

	@RequestMapping(value = "/waiting", method = RequestMethod.DELETE)
	public void waitDelete(@RequestParam("num") int m_num) {

		service.waitingRemove(m_num);

	}

	@RequestMapping(value = "/waiting/defer", method = RequestMethod.PUT)
	public void waitDefer(@RequestParam("num") int m_num) {

		service.waitingDefer(m_num);

	}

	@RequestMapping(value = "/waiting/m_examination", method = RequestMethod.PUT)
	public void waitM_examination(@RequestParam("num") int m_num) {

		service.waitingm_examination(m_num);

	}

	@RequestMapping(value = "/waiting/wait", method = RequestMethod.PUT)
	public void waitWait(@RequestParam("num") int m_num) {

		service.waitingwait(m_num);

	}

	@RequestMapping(value = "/waiting/defer", method = RequestMethod.GET)
	public List<Waiting> waitdefer2() {

		return service.deferSearch();
	}
}

/*
 * @RequestMapping(value = "/modifyForm") public ModelAndView
 * modifyForm(@RequestBody Member member) {
 * if(request.getServletPath().equals("/tnum")) { // 여기 서 주석처뤼
 * 
 * }else if(request.getServletPath().equals("/dnum"))
 * 
 * ModelAndView mav = new ModelAndView(); //mav.addObject("member",
 * service.memberSearch(member));
 * 
 * mav.setViewName("/member/modifyForm");
 * 
 * return mav; }
 * 
 * //Join
 * 
 * @RequestMapping("/joinForm") public String joinForm(Member member) {
 * 
 * return "/member/joinForm"; }
 * 
 * @RequestMapping(value = "/join", method = RequestMethod.POST) public String
 * joinReg(Member member) {
 * 
 * service.memberRegister(member);
 * 
 * return "/member/joinOk"; } // Remove
 * 
 * @RequestMapping("/removeForm") public ModelAndView removeForm( @RequestBody
 * Member member) {
 * 
 * ModelAndView mav = new ModelAndView();
 * 
 * 
 * 
 * mav.addObject("member", member); mav.setViewName("/member/removeForm");
 * 
 * 
 * return mav; }
 */
//	@DeleteMapping(value="/") 처방전 삭제
//public void remove(@RequestBody Prescription_drug drug) {

//}
//@RequestMapping(method = RequestMethod.POST)
//public Prescription_drug add2(@RequestBody Prescription_drug drug) {
//	service.drugRegister(drug);
//	return drug;
//}
/*
 * List<Prescription_drug> drug = pre.getDrugs(); int count = drug.size();
 * for(int i=0; i<count; i++) { Prescription_drug _d = drug.get(i);
 * System.out.println(_d.getDrug_name()); System.out.println(_d.getDose());
 * System.out.println(_d.getDtime());
 * 
 * }
 */