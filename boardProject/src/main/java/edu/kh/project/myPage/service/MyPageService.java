package edu.kh.project.myPage.service;

import org.springframework.web.multipart.MultipartFile;

import edu.kh.project.member.dto.Member;

public interface MyPageService {

	/** 회원 정보 수정
	 * @param inputMember
	 * @return
	 */
	int updateInfo(Member inputMember);

	int checkNickname(String input);

	int changePw(String currentPw, String newPw, Member loginMember);

	int secession(String memberPw, Member loginMember);

	String profile(MultipartFile profileImg, int memberNo);

}
