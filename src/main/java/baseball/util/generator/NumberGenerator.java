package baseball.util.generator;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class NumberGenerator {

    private static final Integer BALL_SIZE = 3;
    private final static Integer FIRST_NUMBER = 1;
    private final static Integer LAST_NUMBER = 9;

    public List<Integer> getGeneratedNumbers() {
        List<Integer> answer = new ArrayList<>();
        while (answer.size() < BALL_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(FIRST_NUMBER, LAST_NUMBER);
            addIfNotInList(answer, randomNumber);
        }
        return answer;
    }

    private void addIfNotInList(List<Integer> answer, int randomNumber) {
        if (!answer.contains(randomNumber)) {
            answer.add(randomNumber);
        }
    }
}
