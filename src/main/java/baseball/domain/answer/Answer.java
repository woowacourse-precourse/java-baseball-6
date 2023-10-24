package baseball.domain.answer;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Answer {
    private final List<Integer> answer;

    public Answer() {
        this.answer = createAnswer();
    }

    public List<Integer> toIntList() {
        return answer;
    }

    private List<Integer> createAnswer() {
        Set<Integer> answer = new HashSet<>();
        while (answer.size() < 3) {
            answer.add(Randoms.pickNumberInRange(1, 9));
        }
        return new ArrayList<>(answer);
    }
}
