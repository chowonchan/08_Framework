package edu.kh.project.main.service;

import java.util.List;

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
	
	@Override
	public List<Member> selectMemberList() {

		return mapper.selectMemberList();
	}
}

