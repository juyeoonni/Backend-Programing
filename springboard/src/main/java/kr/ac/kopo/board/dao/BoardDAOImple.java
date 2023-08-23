package kr.ac.kopo.board.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.board.vo.BoardVO;

@Repository
public class BoardDAOImple implements BoardDAO {

	
		@Autowired
		private SqlSessionTemplate sqlSessionTemplate;

		@Override
		public List<BoardVO> getAllPost() {
			List<BoardVO> boardlist = sqlSessionTemplate.selectList("springboard.board.dao.BoardDAO.selectAll");
		
			return boardlist;
		}
		
		
	

}
