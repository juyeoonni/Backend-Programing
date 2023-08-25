package kr.ac.kopo.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kr.ac.kopo.member.dao.MemberDAO;
import kr.ac.kopo.member.vo.LoginVO;
import kr.ac.kopo.member.vo.MemberVO;

@Service
public class MemberServiceImple implements MemberService {
    @Autowired
    private MemberDAO memberDAO;

    @Override
    public MemberVO login(LoginVO loginVO) {

        return memberDAO.login(loginVO);
    }
    
    @Override
    public void join(MemberVO memberVO) {
        memberDAO.join(memberVO);        
    }

}