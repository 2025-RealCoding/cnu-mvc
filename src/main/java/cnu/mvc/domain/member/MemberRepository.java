package cnu.mvc.domain.member;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class MemberRepository {

    private static final Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }
    public Member findById(Long id) {
        return store.get(id);
    }

    // 구현
    public Member findByEmail(String email) {
        // store에 저장된 모든 member를 돌며 이메일이 일치하는 경우 반환
        return store.values()
                .stream()
                .filter(member -> member.getEmail().equals(email))
                .findFirst()
                .orElse(null); // 없으면 null 반환
    }
}

