package cnu.mvc.domain.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public Member join(Member member){
        // 들어온 멤버의 email을 가져옵니다.
        String joinEmail = member.getEmail();
        // 만약 member를 가져와 null이 아니라면 이미 존재하는 이메일 이므로
        // IllegalArgumentException을 발생합니다.
        if (findByEmail(joinEmail) != null) {
            throw new IllegalArgumentException("이미 존재하는 이메일 계정입니다.");
        }
        // null인경우 member가 존재하지 않으므로
        return memberRepository.save(member);
    }

    public Member validateMember(String email, String pwd) {
        Member findMember;
        // 입력받은 email로 member를 찾습니다.
        // 들어온 email로 멤버를 찾아 ()을 통해 우선순위를 높여 finMember에 저장을 합니다.
        // 그후에 null또는 pwd가 다르다면 오류를 발생합니다.
        if ((findMember = memberRepository.findByEmail(email)) == null || !findMember.getPwd().equals(pwd)) {
            throw new IllegalArgumentException("이메일 또는 비밀번호를 확인해주세요.");
        }
        return findMember;
    }

    public Member findById(Long id) {
        return memberRepository.findById(id);
    }

    // 구현
    // 이미 memberRepository에서 구현했으므로 따로 건들지 않았습니다.
    public Member findByEmail(String email) {
        return memberRepository.findByEmail(email);
    }

}
