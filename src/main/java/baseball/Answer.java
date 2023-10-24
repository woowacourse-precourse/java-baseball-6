package baseball;

import static baseball.constants.Game.ANSWER_DIGIT;
import static baseball.constants.Game.END_INCLUSIVE;
import static baseball.constants.Game.START_INCLUSIVE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;

public class Answer {
    private final String answer;

    public Answer() {
        answer = generateRandomAnswer();
    }

    public String getAnswer() {
        return answer;
    }

    private String generateRandomAnswer() {
        ArrayList<String> randomNumberList = new ArrayList<>(ANSWER_DIGIT);
        while (randomNumberList.size() < ANSWER_DIGIT) {
            int randomNumber = Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
            if (!randomNumberList.contains("" + randomNumber)) {
                randomNumberList.add("" + randomNumber);
            }
        }

        return String.join("", randomNumberList);
    }
}
