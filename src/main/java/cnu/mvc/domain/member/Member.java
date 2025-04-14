package cnu.mvc.domain.member;

import java.beans.ConstructorProperties;
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
    // 데이터가 넘어왔을 때 생성자에 대해서 매핑을 하지 못하는 오류가 발생하여 아래의 어노테이션을 작성했습니다.
    @ConstructorProperties({"email", "name", "pwd", "role"})
    public Member(String name, String email, String phoneNumber, String pwd) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.pwd = pwd;
    }
}
