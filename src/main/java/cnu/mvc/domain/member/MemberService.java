package cnu.mvc.domain.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    // 수정
    public Member join(Member member) throws Exception {
        Member mem = memberRepository.findByEmail(member.getEmail());
        if(mem == null){
            memberRepository.save(member);
        } else {
            throw new Exception("이미 존재하는 이메일 계정입니다.");
        }

        return memberRepository.save(member);
    }

    // 수정
    public Member validateMember(String email, String pwd) throws Exception {
        Member findMember = findByEmail(email);

        if(findMember == null){
            throw new Exception("이메일 또는 비밀번호를 확인해주세요.");
        }

        if (!pwd.equals(findMember.getPwd())) {
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
