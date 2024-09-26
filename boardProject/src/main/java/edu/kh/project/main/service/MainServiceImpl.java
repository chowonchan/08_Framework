package edu.kh.project.main.service;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.kh.project.main.mapper.MainMapper;
import edu.kh.project.member.dto.Member;
import lombok.RequiredArgsConstructor;

@Transactional
@Service
@RequiredArgsConstructor // 생성자 생성 -> 생성자 방식 의존성 주입 수행
public class MainServiceImpl implements MainService {
	
	// @Autowired 쓰지 않아도 됨, 의존성 자동 주입
	private final MainMapper mapper;
	private final BCryptPasswordEncoder encoder;
	
	@Override
	public List<Member> selectMemberList() {

		return mapper.selectMemberList();
	}
	

	@Override
	public Member directLogin(int memberNo) {

		return mapper.directLogin(memberNo);
	}

	// 비밀번호 암호화 초기화
	@Override
	public int resetPw(int memberNo) {
		
		String encPw = encoder.encode("pass01!");
	
		return mapper.resetPw(memberNo, encPw);
	}

	
	@Override
	public int changeStatus(int memberNo) {
		return mapper.changeStatus(memberNo);
	}

}






