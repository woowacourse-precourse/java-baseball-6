package baseball;

import static baseball.BaseballGame.ANSWER_DIGIT;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {

    private List<Integer> correctAnswer = new ArrayList<>();

    private static final int NUMBER_START_RANGE = 1;
    private static final int NUMBER_END_RANGE = 9;

    public List<Integer> createCorrectAnswer() {
        correctAnswer.clear();
        while (correctAnswer.size() < ANSWER_DIGIT) {
            int pickedNumberInRange = Randoms.pickNumberInRange(NUMBER_START_RANGE, NUMBER_END_RANGE);
            if (!correctAnswer.contains(pickedNumberInRange)) {
                correctAnswer.add(pickedNumberInRange);
            }
        }
        return correctAnswer;
    }


}
