package cnu.mvc.domain.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    // 1-2) 회원가입 시 중복 이메일 검증
    public Member join(Member member) {
        if (memberRepository.findByEmail(member.getEmail()) != null) {
            throw new IllegalStateException("이미 존재하는 이메일 계정입니다.");
        }
        return memberRepository.save(member);
    }

    // 2-1) 로그인 검증
    public Member validateMember(String email, String pwd) {
        Member findMember = memberRepository.findByEmail(email);
        if (findMember == null || !findMember.getPassword().equals(pwd)) {
            throw new IllegalArgumentException("이메일 또는 비밀번호를 확인해주세요.");
        }
        return findMember;
    }

    // 기타 기능
    public Member findById(Long id) {
        return memberRepository.findById(id);
    }

    public Member findByEmail(String email) {
        return memberRepository.findByEmail(email);
    }
}
