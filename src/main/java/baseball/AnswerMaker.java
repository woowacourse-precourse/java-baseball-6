package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AnswerMaker {
    private final List<Integer> answer;

    public int makeNumbers(int min, int max) {
        return (Randoms.pickNumberInRange(min, max));
    }

    public AnswerMaker(int min, int max) {
        Set<Integer> numbers = new HashSet<>();
        while (numbers.size() < 3) {
            numbers.add(makeNumbers(min, max));
        }
        this.answer = new ArrayList<>(numbers);
    }

    public List<Integer> getAnswer() {
        return answer;
    }
}
