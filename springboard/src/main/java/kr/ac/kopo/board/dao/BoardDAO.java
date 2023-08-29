package kr.ac.kopo.board.dao;

import java.util.List;
import kr.ac.kopo.board.vo.BoardVO;

public interface BoardDAO {
	List<BoardVO> getAllPost();
	BoardVO getPostbyNo(int no);
	void writeNewPost(BoardVO boardVO);
	void increaseCount(int no);
	void decreaseCount(int bno);
	
}
