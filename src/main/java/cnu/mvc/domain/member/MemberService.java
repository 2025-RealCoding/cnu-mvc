package cnu.mvc.domain.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    // 회원가입 메서드
    public Member join(Member member) {
        // 동일한 이메일이 존재하는지 검증
        if (findByEmail(member.getEmail()) != null) {
            throw new IllegalArgumentException("이미 존재하는 이메일 계정입니다.");
        }
        return memberRepository.save(member);
    }

    // 로그인 검증 메서드
    public Member validateMember(String email, String pwd) {
        // 입력받은 이메일로 회원 조회
        Member member = findByEmail(email);
        // 이메일이 없거나 비밀번호가 일치하지 않는 경우 예외 발생
        if (member == null || !member.getPwd().equals(pwd)) {
            throw new IllegalArgumentException("이메일 또는 비밀번호를 확인해주세요.");
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
