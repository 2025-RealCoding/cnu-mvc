package cnu.mvc.domain.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public Member join(Member member){
        return memberRepository.save(member);
    }

    public Member validateMember(String email, String pwd) {
        Member findMember = findById(1L);
        return findMember;
    }

    public Member findById(Long id) {
        return memberRepository.findById(id);
    }

    // 구현
    public Member findByEmail(String email) {
        for (Member member : store.values()) {
            if(member.getEmail().equals(email)){
                return member;
            }
        }
        return null;
    }

}
