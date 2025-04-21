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
        // 저장소에 회원 정보 꺼냄.
        for (Member member : store.values()) {
            // 일치하면 반환.
            if (member.getEmail().equals(email)) {
                return member;
            }
        }
        // 일치하지 않으면, null 반환.
        return null;
    }
}

