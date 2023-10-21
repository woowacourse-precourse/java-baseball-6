package baseball.game.repository;

import baseball.game.entity.Member;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class MemberRepository {
    private static long id = 0L;
    private static Map<Long, Member> store = new HashMap<>();
    private static MemberRepository instance;

    private MemberRepository() {
    }

    public static MemberRepository getInstance() {
        if (instance == null) {
            return instance = new MemberRepository();
        }
        return instance;
    }

    public Member save(Member member) {
        member.setId(++id);
        store.put(member.getId(), member);
        return member;
    }

    public Optional<Member> findBy(Long id) {
        return Optional.ofNullable(store.get(id));
    }
}
