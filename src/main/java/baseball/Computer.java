package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {

    private List<Integer> correctAnswer = new ArrayList<>();

    private static final int NUMBER_START_RANGE = 1;
    private static final int NUMBER_END_RANGE = 9;
    private static final int ANSWER_DIGIT = 3;

    public List<Integer> createCorrectAnswer() {
        while (correctAnswer.size() < ANSWER_DIGIT) {
            int pickedNumberInRange = Randoms.pickNumberInRange(NUMBER_START_RANGE, NUMBER_END_RANGE);
            if (!correctAnswer.contains(pickedNumberInRange)) {
                correctAnswer.add(pickedNumberInRange);
            }
        }
        return correctAnswer;
    }


}
