package baseball.Model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class AnswerNumber {

    private static final int NUMBER_SIZE = 3;
    private static final int MIN_NUMBER_RANGE = 1;
    private static final int MAX_NUMBER_RANGE = 9;

    private final List<Integer> answerNumber = new ArrayList<>();

    public AnswerNumber() {
        generateAnswerNumber();
    }

    private void generateAnswerNumber() {
        while (answerNumber.size() < NUMBER_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER_RANGE, MAX_NUMBER_RANGE);
            if (!answerNumber.contains(randomNumber)) {
                answerNumber.add(randomNumber);
            }
        }
    }

    public List<Integer> getAnswerNumber() {
        return answerNumber;
    }


}
