package baseball.domain.answer;

import baseball.domain.validation.Validation;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.IntStream;

public class Answer {
    private final List<Integer> answer;

    public Answer() {
        List<Integer> integerList = createAnswer();
        Validation.isDuplicate(integerList);
        this.answer = integerList;
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
