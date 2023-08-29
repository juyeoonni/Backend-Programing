package kr.ac.kopo.board.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.ac.kopo.board.service.BoardService;
import kr.ac.kopo.board.vo.BoardVO;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	//http://localhost:8080/springboard/board/new
	@PostMapping("/board/new")
	public String newPostProcess(@Valid BoardVO boardVO, BindingResult br) {	
		if(br.hasErrors()) {
			System.out.println(" Error!!!!");			
			return "board/writeForm";   // view name : /board/boardlist.jsp
			//View-Resolver :  WEB-INF/jsp/  board/boardlist  .jsp
		}else {		
			System.out.println("error가 없습니다.");
			boardService.writeNewPost(boardVO);
			return "redirect:/board"; 	 
			//http://localhost:8080/springboard/board
		}		 
	}
	
	//http://localhost:8080/springboard/board/new
	@GetMapping("/board/new")
	public String newPost(Model model) {		
		//만들어서 jsp 보내줌
		BoardVO boardVO = new BoardVO();
		//boardVO.setTitle("기본제목");
		model.addAttribute("boardVO",boardVO);		
		return "board/writeForm";	
		//WEB-INF/jsp/board/writeFrom.jsp
	}	
	
	
	//http://localhost:8080/springboard/board/10
	@GetMapping("/board/{no}")
	public String getPostbyNo2(	@PathVariable("no") int no,
								Model model) {				
		BoardVO boardVO = boardService.getPostbyNo(no);
		model.addAttribute("boardVO",boardVO);
		return "board/detail";  //WEB-INF/jsp/board/detail.jsp
	}  
	// http://localhost:8080/springboard/post?no=10
	//@GetMapping("/post")
	public String getPostbyNo(	@RequestParam("no") int no
								,Model model) {
		
		BoardVO boardVO = boardService.getPostbyNo(no);
		model.addAttribute("boardVO",boardVO);
		return "board/detail";  //WEB-INF/jsp/board/detail.jsp
	}
	
	
	//http://localhost:8080/springboard/board
	@GetMapping("/board")
	public ModelAndView getAllBoard() {		
		ModelAndView mav = new ModelAndView("board/boardlist");
		List<BoardVO> boardlist = boardService.getAllBoard();
		mav.addObject("boardlist", boardlist);		
		//WEB-INF/jsp/  board/boardlist   .jsp
		return mav;
	}
	
}
