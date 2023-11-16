package baseball.game.entity;

import java.util.ArrayList;
import java.util.List;

public class Member {
    private Long id;
    private List<Integer> numbers = new ArrayList<>();

    public static Member create(List<Integer> numbers) {
        Member member = new Member();
        member.numbers = numbers;

        return member;
    }

    public Long getId() {
        return id;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
