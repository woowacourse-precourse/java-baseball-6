package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class AnswerGenerator {

    private final static int startInclusive = 1;
    private final static int endInclusive = 9;
    private final static int answerSize = 3;

    public List<Integer> generateAnswer() {
        List<Integer> answer = new ArrayList<>();
        while (answer.size() < answerSize) {
            int randomNumber = Randoms.pickNumberInRange(startInclusive, endInclusive);
            addRandomNumber(answer, randomNumber);
        }
        return answer;
    }

    private void addRandomNumber(List<Integer> answer, int randomNumber) {
        if (validate(answer, randomNumber)) {
            answer.add(randomNumber);
        }
    }

    private boolean validate(List<Integer> answer, int randomNumber) {
        return !answer.contains(randomNumber);
    }

}