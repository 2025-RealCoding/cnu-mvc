package cnu.mvc.domain.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public Member join(Member member) {
        if (findByEmail(member.getEmail()) != null) {
            throw new RuntimeException("이미 존재하는 이메일 계정입니다.");
        }
        return memberRepository.save(member);
    }

    public Member validateMember(String email, String pwd) {

        Member findMember = findByEmail(email);   // 이메일을 기반한 아이디를 통해 멤버 식별
        if (findMember == null || !findMember.getPwd().equals(pwd)) {
            throw new RuntimeException("이메일 또는 비밀번호를 확인해주세요");  // 아이디 또는 비밀번호가 잘못되었을 경우 { throw }
        }
        return findMember;
    }

    public Member findById(Long id) {
        return memberRepository.findById(id);
    }

    // 구현
    public Member findByEmail(String email) {
        return memberRepository.findByEmail(email);
    }

}
