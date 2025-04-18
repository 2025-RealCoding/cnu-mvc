package cnu.mvc.domain.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public Member join(Member member){
        // 이메일 중복 구현
        if(findByEmail(member.getEmail()) != null ) {
            throw new IllegalStateException("이미 존재하는 이메일 계정입니다.");
        }
        return memberRepository.save(member);
    }

    public Member validateMember(String email, String pwd) {
        Member check_member = findByEmail(email);

        if (check_member == null || !check_member.getPwd().equals(pwd)){
            
            throw new IllegalArgumentException("이메일 또는 비밀번호를 확인해주세요.");
            
        }
        return check_member;
    }

    public Member findById(Long id) {
        return memberRepository.findById(id);
    }

    // 구현
    public Member findByEmail(String email) {
        return memberRepository.findByEmail(email);
    }
}
