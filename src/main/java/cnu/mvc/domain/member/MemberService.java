package cnu.mvc.domain.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public Member join(Member member){
        // 이미 존재하는 이메일인지 확인
        Member existingMember = findByEmail(member.getEmail());
        if (existingMember != null) {
            throw new IllegalArgumentException("이미 존재하는 이메일 계정입니다.");
        }
        return memberRepository.save(member);
    }

    public Member validateMember(String email, String pwd) {

        Member findMember = findByEmail(email);  // 1-1에서 만든 메서드 활용
        if (findMember == null || !findMember.getPwd().equals(pwd)) {
            throw new IllegalArgumentException("이메일 또는 비밀번호를 확인해주세요.");
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
