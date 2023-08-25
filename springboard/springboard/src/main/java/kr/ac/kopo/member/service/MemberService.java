package kr.ac.kopo.member.service;

import kr.ac.kopo.member.vo.LoginVO;
import kr.ac.kopo.member.vo.MemberVO;

public interface MemberService {
    MemberVO login(LoginVO loginVO);

	void join(MemberVO memberVO);

}