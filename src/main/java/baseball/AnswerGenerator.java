package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class AnswerGenerator {

    private final List<Integer> answer = new ArrayList<>();

    private final static int startInclusive = 1;
    private final static int endInclusive = 9;
    private final static int answerSize = 3;

    public List<Integer> generate() {
        answer.clear();
        while (answer.size() < answerSize) {
            addRandomNumber();
        }
        return answer;
    }

    private void addRandomNumber() {
        final int randomNumber = Randoms.pickNumberInRange(startInclusive, endInclusive);
        if (validate(randomNumber)) {
            answer.add(randomNumber);
        }
    }

    private boolean validate(int randomNumber) {
        return !answer.contains(randomNumber);
    }

}