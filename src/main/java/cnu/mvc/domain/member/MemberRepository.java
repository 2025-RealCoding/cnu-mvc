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
        for(Long id : store.keySet()){
            Member mem = store.get(id);
            if(mem.getEmail().equals(email)){
                return mem;
            }
        }
        return null;
    }
}

