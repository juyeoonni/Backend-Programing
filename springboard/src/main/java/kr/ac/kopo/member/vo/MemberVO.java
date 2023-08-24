package kr.ac.kopo.member.vo;

public class MemberVO {
	private int no;
	private String id;
	private String password;
	private String name;
	private String addr;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	@Override
	public String toString() {
		return "MemberVO [no=" + no + ", id=" + id + ", password=" + password + ", name=" + name + ", addr=" + addr
				+ "]";
	}

	
}
