package cnu.mvc.domain.member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public Member save(Member member) {
        return memberRepository.save(member);
    }

    public Member findById(Long id) {
        return memberRepository.findById(id);
    }

    // 1-1) findByEmail 메서드 구현
    public Optional<Member> findByEmail(String email) {
        return memberRepository.findByEmail(email);
    }

    // 1-2) join 메서드 구현
    public Member join(Member member) {
        // 1-3) 이메일 중복 검사
        if (findByEmail(member.getEmail()).isPresent()) {
            throw new IllegalArgumentException("이미 존재하는 이메일 계정입니다.");
        }

        return memberRepository.save(member);
    }


    // 2-1) validateMember 메서드 구현
    public void validateMember(String email, String password) {
        // 이메일로 회원 조회
        Optional<Member> memberOpt = findByEmail(email);

        // 회원이 없으면 예외 발생
        if (memberOpt.isEmpty()) {
            throw new IllegalArgumentException("이메일 또는 비밀번호를 확인해주세요.");
        }

        // 비밀번호 비교
        Member member = memberOpt.get();
        if (!member.getPwd().equals(password)) {
            throw new IllegalArgumentException("이메일 또는 비밀번호를 확인해주세요.");
        }
    }


}