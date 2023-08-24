package kr.ac.kopo.member.dao;

import kr.ac.kopo.member.vo.LoginVO;
import kr.ac.kopo.member.vo.MemberVO;

public interface MemberDAO {
    
    MemberVO login(LoginVO loginVO);
}