package cnu.mvc.domain.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    // 회원 가입
    public Member join(Member member) {
        Member findMember = findByEmail(member.getEmail());
        if (findMember != null) {
            // 이미 등록된 이메일인 경우 예외 발생
            throw new IllegalStateException("이미 존재하는 이메일 계정입니다.");
        }
        // 새 회원 저장
        return memberRepository.save(member);
    }

    // 로그인 유효성 검사
    public Member validateMember(String email, String pwd) {
        Member findMember = findByEmail(email);

        // 이메일이 없거나 비밀번호가 틀린 경우 예외 발생
        if (findMember == null || !findMember.getPwd().equals(pwd)) {
            throw new IllegalStateException("이메일 또는 비밀번호를 확인해주세요.");
        }

        // 로그인 성공
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
