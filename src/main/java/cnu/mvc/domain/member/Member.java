package cnu.mvc.domain.member;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
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
}
