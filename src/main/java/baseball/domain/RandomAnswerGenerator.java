package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomAnswerGenerator implements AnswerGenerator {

    private static final int ANSWER_SIZE = 3;
    private static final int MIN_BASEBALL_NUMBER = 1;
    private static final int MAX_BASEBALL_NUMBER = 9;

    @Override
    public Answer generate() {
        List<Integer> answer = new ArrayList<>();
        while (answer.size() < ANSWER_SIZE) {
            addNonDuplicatedNumber(answer);
        }
        return new Answer(answer);
    }

    private static void addNonDuplicatedNumber(List<Integer> answer) {
        int number = Randoms.pickNumberInRange(MIN_BASEBALL_NUMBER, MAX_BASEBALL_NUMBER);
        if (!answer.contains(number)) {
            answer.add(number);
        }
    }
}
