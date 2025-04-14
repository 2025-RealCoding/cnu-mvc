package cnu.mvc.domain.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public Member join(Member member){
        if (findByEmail(member.getEmail()) != null) {
            // 2. 이미 존재하는 이메일일 경우 예외 발생
            throw new IllegalArgumentException("이미 존재하는 이메일 계정입니다.");
        }

        // 3. 저장
        return memberRepository.save(member);
    }

    public Member validateMember(String email, String pwd) {
        // 1. 이메일로 회원 찾기
        Member findMember = findByEmail(email);

        // 2. 이메일 없거나 비밀번호 틀린 경우 예외 발생
        if (findMember == null || !findMember.getPwd().equals(pwd)) {
            throw new IllegalArgumentException("이메일 또는 비밀번호를 확인해주세요.");
        }

        // 3. 인증 성공 시 회원 반환
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
