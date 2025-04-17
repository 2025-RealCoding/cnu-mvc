package cnu.mvc.domain.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public Member join(Member member){
        if (memberRepository.findByEmail(member.getEmail())!=null){
            throw new IllegalStateException("이미 존재하는 이메일 계정입니다.");
        }

        return memberRepository.save(member);
    }

    public Member validateMember(String email, String pwd) {
        Member member = memberRepository.findByEmail(email);

        if (member == null || !member.getPwd().equals(pwd)) {
            throw new IllegalArgumentException("이메일 또는 비밀번호가 일치하지 않습니다.");
        }
        return member;
    }

    public Member findById(Long id) {
        return memberRepository.findById(id);
    }

    // 구현
    public Member findByEmail(String email) {

        return memberRepository.findByEmail(email);
    }

}
