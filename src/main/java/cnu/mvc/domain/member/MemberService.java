package cnu.mvc.domain.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public Member join(Member member){
        validateDuplicateMember(member);
        return memberRepository.save(member);
    }

    private void validateDuplicateMember(Member member){
        Member findMember = memberRepository.findByEmail(member.getEmail());
        if (findMember != null) {
            throw new IllegalStateException("이미 존재하는 이메일 계정입니다.");
        }
    }
    public Member validateMember(String email, String pwd) {
        Member findMember = findByEmail(email);
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
