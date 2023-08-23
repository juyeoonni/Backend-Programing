package kr.ac.kopo.board.vo;

public class BoardVO {
	private int no;
	private String title;
	private String writer;
	private String content;
	private String reg_date;
	private int count;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegDate() {
		return reg_date;
	}
	public void setRegDate(String regDate) {
		this.reg_date = regDate;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	@Override
	public String toString() {
		return "BoardVO [no=" + no + ", title=" + title + ", writer=" + writer + ", content=" + content + ", reg_date="
				+ reg_date + ", count=" + count + "]";
	}

	
}
