package kr.ac.kopo.test;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.sql.DataSource;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.ac.kopo.board.service.BoardServiceImpl;
import kr.ac.kopo.board.vo.BoardVO;

@ContextConfiguration(locations = {"classpath:config/spring/spring-config.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class SessionTest {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private BoardServiceImpl boardServiceImpl;
	
	@Test
    public void selectByNoTest() {
        BoardVO board = sqlSessionTemplate.selectOne("springboard.board.dao.BoardDAO.selectbyNo",2);        
        System.out.println(board);                
    }  
	
	
	@Test
	public void BoardServiceTest() {
		List<BoardVO> boardlist = boardServiceImpl.getAllBoard();
		
		for (BoardVO boardVO : boardlist) {
			System.out.println(boardVO);
		}
	}
	
	
	@Ignore
	@Test
	public void sessionTemplateTest() {
		assertNotNull(sqlSessionTemplate);
		System.out.println(sqlSessionTemplate);
	}
	
	@Ignore
	@Test
	public void boardSelectAllTest() {
		List<BoardVO> boardlist = 
		sqlSessionTemplate.selectList("springboard.board.dao.BoardDAO.selectAll");
		
		for (BoardVO boardVO : boardlist) {
			System.out.println(boardVO);
		}
	}
}
