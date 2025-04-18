package cnu.mvc.domain.member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public Member save(Member member){
        return memberRepository.save(member);
    }
    public Member findById(Long id) {
        return memberRepository.findById(id);
    }

    public Member validateMember(String email, String pwd) {
        Member findMember = memberRepository.findByEmail(email);
        if(findMember == null || !findMember.getPwd().equals(pwd)){
            throw new IllegalStateException("이메일 또는 비밀번호를 확인해주세요.");
        }
        return findMember;
    }

    public Member join(Member member) {
        validateMember(member.getEmail());
        return memberRepository.save(member);
    }

    private void validateMember(String email) {
        Member existing = memberRepository.findByEmail(email);
        if(existing != null){
            throw new IllegalStateException("이미 존재하는 이메일 계정입니다.");
        }
    }

}