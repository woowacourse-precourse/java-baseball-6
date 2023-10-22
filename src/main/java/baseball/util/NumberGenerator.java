package baseball.util;

import baseball.model.Answer;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class NumberGenerator {
    private static final int MIN_NUM = 1;
    private static final int MAX_NUM = 9;
    private static final int ANSWER_SIZE = 3;

    public Answer createAnswer() {
        List<Integer> answer = new ArrayList<>();

        while (answer.size() != ANSWER_SIZE) {
            isAnswerHasDuplicatedValue(answer, Randoms.pickNumberInRange(MIN_NUM, MAX_NUM));
        }

        return new Answer(answer);
    }

    private void isAnswerHasDuplicatedValue(List<Integer> answer, int randNum) {
        if (!answer.contains(randNum)) {
            answer.add(randNum);
        }
    }
}
