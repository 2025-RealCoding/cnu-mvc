package cnu.mvc.domain.member;
import org.springframework.stereotype.Repository;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class MemberRepository {
    private static final Map<Long, Member> store = new HashMap<>(); //store의 key는 회원ID
    private static long sequence = 0L;//sequence는 회원ID를 생성할 때 사용되는 일련번호

    // 새로운 회원 객체를 받아와 ID를 자동으로 설정하고, store에 저장
    public Member save(Member member) {
        member.setId(++sequence); // ID를 1증가시키고 저장
        store.put(member.getId(), member);
        return member;
    }

    //회원 ID를 기준으로 회원 정보 조회
    public Member findById(Long id) {
        return store.get(id);
    }

    //구현
    //모든 회원을 순회하면서 이메일이 일치하는 회원을 찾아서 반환
    /*public Member findByEmail(String email) {
        for (Member m : store.values()) {
            if (m.getEmail().equals(email)) {
                return m;
            }
        }
        return null; //일치하는 이메일이 없으면 null반환
    }*/

    // 1-1) findByEmail 메서드 구현
    public Optional<Member> findByEmail(String email) {
        return store.values().stream()
                .filter(m -> email.equals(m.getEmail()))
                .findFirst();
    }



}