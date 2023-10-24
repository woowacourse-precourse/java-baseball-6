package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;

public class Answer {
    private String answer;
    int START_INCLUSIVE = Constants.START_INCLUSIVE;
    int END_INCLUSIVE = Constants.END_INCLUSIVE;
    int ANSWER_DIGIT = Constants.ANSWER_DIGIT;

    public Answer() {
        this.answer = generateRandomAnswer();
    }

    public String getAnswer() {
        return this.answer;
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
