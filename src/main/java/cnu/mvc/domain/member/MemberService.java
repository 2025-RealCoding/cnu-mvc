package cnu.mvc.domain.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public Member join(Member member) throws Exception {
        if (findByEmail(member.getEmail()) != null) {
            throw new Exception("이미 존재하는 이메일 계정입니다.");
        }

        return memberRepository.save(member);
    }

    public Member validateMember(String email, String pwd) throws Exception {
        Member findMember = findByEmail(email);

        if (findMember == null || !Objects.equals(findMember.getPwd(), pwd)) {
            throw new Exception("이메일 또는 비밀번호를 확인해주세요.");
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
