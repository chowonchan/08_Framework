package edu.kh.project.main.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.SessionAttributes;

import edu.kh.project.main.service.MainService;
import edu.kh.project.member.dto.Member;
import lombok.RequiredArgsConstructor;

// model에 세팅된 key 중에서 일치하는 요소를 session scope로 변경
@SessionAttributes({"loginMember"})
@Controller // 요청 / 응답 제어 하는 역할 명시 + Bean 등록
@RequiredArgsConstructor
public class MainController {
	
	private final MainService service;
	

	@RequestMapping("/") // "/" 요청 매핑(method 가리지 않음)
	public String mainPage() {
		
		// 접두사 : classpath:/templates/
		// 접미사 : .html
		// -> forward 하려는 파일의 ThymeLeaf 
		//   접두사, 접미사를 제외한 경로 작성
		return "common/main";
	}
	
	/** 비동기 회원 목록 조회
	 * @return
	 */
	@ResponseBody
	@GetMapping("selectMemberList")
	public List<Member> selectMemberList(){
		return service.selectMemberList();
	}
	
	
	/** 빠른 로그인
	 * @param memberNo
	 * @param model
	 * @return
	 */
	@PostMapping("directLogin")
	public String directLogin(
			@RequestParam("memberNo") int memberNo,
			Model model) {
		
		Member loginMember = service.directLogin(memberNo);
		
		// 로그인된 회원 정보를 session에 추가
		model.addAttribute("loginMember", loginMember);
		
		return "redirect:/";
	}
	
	@ResponseBody
	@PostMapping("resetPw")
	public int resetPw(
			@RequestBody int memberNo) {
		
		int result = service.resetPw(memberNo);
		
		return result;
	}
	
	@ResponseBody
	@PutMapping("changeStatus")
	public int changeStatus(@RequestBody int memberNo) {
		int result = service.changeStatus(memberNo);
		
		return result;
	}
	
	
	
	
	
}
