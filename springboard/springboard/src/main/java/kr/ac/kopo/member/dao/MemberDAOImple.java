package kr.ac.kopo.member.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import kr.ac.kopo.member.vo.LoginVO;
import kr.ac.kopo.member.vo.MemberVO;

@Repository
public class MemberDAOImple implements MemberDAO {

    @Autowired
    SqlSessionTemplate sqlSessionTemplate;

    @Override
    public MemberVO login(LoginVO loginVO) {
        MemberVO memberVO =
                sqlSessionTemplate.selectOne("springboard.member.dao.MemberDAO.login", loginVO);
        return memberVO;
    }
    
    @Override
    public void join(MemberVO memberVO) {
        sqlSessionTemplate.insert("springboard.member.dao.MemberDAO.join", memberVO);
        
    }

}