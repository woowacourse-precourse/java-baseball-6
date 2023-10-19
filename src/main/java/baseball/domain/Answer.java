package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.IntStream;

public class Answer {
    private List<Integer> answer;

    public Answer() {
        this.answer = createAnswer();
    }

    public List<Integer> toIntList() {
        return answer;
    }
    private List<Integer> createAnswer() {
        return IntStream.range(0, 3)
                .map(n -> Randoms.pickNumberInRange(1, 9))
                .boxed()
                .toList();
    }
}
