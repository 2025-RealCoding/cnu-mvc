package cnu.mvc.domain.member;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Member {
    private Long id;
    private String name;
    private String email;
    private String phoneNumber;
    private String pwd;

    public Member(String name, String email, String phoneNumber, String pwd) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.pwd = pwd;
    }
    public String getPwd(){return this.pwd;}
}
