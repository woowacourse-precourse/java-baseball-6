package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class AnswerNumber {

    private static final int NUMBER_SIZE = 3;

    private final List<Integer> answerNumber = new ArrayList<>();

    public AnswerNumber() {
        generateAnswerNumber();
    }

    private void generateAnswerNumber() {
        while (answerNumber.size() < NUMBER_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answerNumber.contains(randomNumber)) {
                answerNumber.add(randomNumber);
            }
        }
    }


}
