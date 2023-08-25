package kr.ac.kopo.member.vo;

import javax.validation.constraints.NotEmpty;

public class MemberVO {

    private int no;
    @NotEmpty(message="이름은 필수입니다.")
    private String name;
    @NotEmpty(message="id 는 필수입니다.")
    private String id;
    @NotEmpty(message="password 는 필수입니다.")
    private String password;
    @NotEmpty(message="주소는 필수입니다.")
    private String addr;

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    @Override
    public String toString() {
        return "MemberVO [no=" + no + ", name=" + name + ", id=" + id + ", password=" + password
                + ", addr=" + addr + "]";
    }



}