package kr.ac.kopo.board.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	//@GetMapping("/post")
//	public String getPostbyNo(@RequestParam("no") int no, Model model) {
//		BoardVO boardVO = boardService.getPostbyNO(no);
//		model.addAttribute("boardVO", boardVO);
//		return "board/detail";
//	}
	
	@GetMapping("/board/{no}")
	public String getPostbyNo2(@PathVariable("no") int no, Model model) {
		BoardVO boardVO = boardService.getPostbyNO(no);
		model.addAttribute("boardVO", boardVO);
		return "board/detail";
	}
	
	@GetMapping("/board/new")
	public String newPost(Model model) {
		BoardVO boardVO = new BoardVO();
		//boardVO.setTitle("기본제목");
		model.addAttribute("boardVO", boardVO);
		
		return "board/writeForm";
	}
	
	// BindingResult: BindingResult는 주로 Controller 메소드의 매개변수로 사용되며, 바로 앞에 위치한 파라미터 (대체로 폼 객체)의 검증 오류를 가져오는 데 사용
	//http://localhost:8080/springboard/board/new
    @PostMapping("/board/new")
    public String newPostProcess(@Valid BoardVO boardVO, BindingResult br) {
        
        if(br.hasErrors()){
            System.out.println(" Error!!! ");
            return "board/writeForm"; //boardlist.jsp
        }
        
        boardService.writeNewPost(boardVO);
        return "redirect:/board";
        //http://localhost:8080/springboard/board
    }
    

	
}
