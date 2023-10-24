package baseball.computer;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Answer {
    private static final int VALID_LENGTH = 3;
    private static final int MIN_VALID_DIGIT = 1;
    private static final int MAX_VALID_DIGIT = 9;

    private final List<Integer> answer = new ArrayList<>();

    public Answer() {
        while (answer.size() < VALID_LENGTH) {
            addUniqueRandomNumber(generateRandomNumber());
        }
    }

    private int generateRandomNumber() {
        return Randoms.pickNumberInRange(MIN_VALID_DIGIT, MAX_VALID_DIGIT);
    }

    private void addUniqueRandomNumber(int randomNumber) {
        if (!answer.contains(randomNumber)) {
            answer.add(randomNumber);
        }
    }

    public List<Integer> getAnswerAsList() {
        return answer;
    }
}
