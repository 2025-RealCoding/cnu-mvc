package cnu.mvc.domain.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public Member join(Member member){
        validateDuplicateEmail(member.getEmail());  // 중복 검사
        return memberRepository.save(member);
    }

    private void validateDuplicateEmail(String email) {
        if (memberRepository.findByEmail(email) != null) {
            throw new IllegalStateException("이미 존재하는 이메일 계정입니다.");
        }
    }

    public Member validateMember(String email, String pwd) {
        // 이메일로 회원 찾기
        Member member = findByEmail(email);

        // 이메일이 존재하지 않으면 null 반환
        if (member == null) {
            throw new IllegalArgumentException("이메일 또는 비밀번호를 확인해주세요.");
        }

        // 비밀번호가 일치하지 않으면 예외 발생
        if (!member.getPwd().equals(pwd)) {
            throw new IllegalArgumentException("이메일 또는 비밀번호를 확인해주세요.");
        }

        // 검증이 성공하면 회원 객체 반환
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
