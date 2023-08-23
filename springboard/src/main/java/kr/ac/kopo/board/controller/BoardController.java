package kr.ac.kopo.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.ac.kopo.board.service.BoardService;
import kr.ac.kopo.board.vo.BoardVO;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	
	//http://localhost:8080/springboard/board
	@GetMapping("/board")
	public ModelAndView getAllBoard() {
		ModelAndView mav = new ModelAndView("board/boardlist"); 
		List<BoardVO> boardlist = boardService.getAllBoard();
		mav.addObject("boardlist", boardlist);
		
		return mav;
	}
	
}
