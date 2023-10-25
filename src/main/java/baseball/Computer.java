package baseball;

import static baseball.BaseballGame.ANSWER_DIGIT;
import static baseball.BaseballGame.NUMBER_MAX_RANGE;
import static baseball.BaseballGame.NUMBER_MIN_RANGE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {

    private List<Integer> correctAnswer = new ArrayList<>();

    public List<Integer> createCorrectAnswer() {
        correctAnswer.clear();
        while (correctAnswer.size() < ANSWER_DIGIT) {
            int pickedNumberInRange = Randoms.pickNumberInRange(NUMBER_MIN_RANGE, NUMBER_MAX_RANGE);
            if (!correctAnswer.contains(pickedNumberInRange)) {
                correctAnswer.add(pickedNumberInRange);
            }
        }
        return correctAnswer;
    }


}
