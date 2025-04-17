package cnu.mvc.domain.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public Member join(Member member) {
        // 이메일 중복 확인
        if (findByEmail(member.getEmail()) != null) {
            throw new IllegalArgumentException("이미 존재하는 이메일 계정입니다.");
        }
        return memberRepository.save(member);  // 이메일 중복 없으면 회원가입
    }



    public Member validateMember(String email, String pwd) {
        // 이메일로 회원 찾기
        Member findMember = findByEmail(email);

        // 이메일이 없으면 예외 처리
        if (findMember == null) {
            throw new IllegalArgumentException("이메일 또는 비밀번호를 확인해주세요.");
        }

        // 비밀번호 확인
        if (!findMember.getPwd().equals(pwd)) {
            throw new IllegalArgumentException("이메일 또는 비밀번호를 확인해주세요.");
        }

        return findMember;  // 로그인 성공 시 회원 반환
    }


    public Member findById(Long id) {
        return memberRepository.findById(id);
    }

    // 구현
    public Member findByEmail(String email) {
        return memberRepository.findByEmail(email);
    }

}
