package baseball;

import java.util.ArrayList;
import java.util.List;

public class Referee {
    private List<Integer> answerList;
    private final int STRIKE = 2;
    private final int BALL = 1;
    private final int NOTHING = 0;

    public List<Integer> judgeUserInput(List<Integer> userInput) {
        int ball = 0;
        int strike = 0;
        for (int i = 0; i < answerList.size(); i++) {
            final int result = judgeNumber(userInput.get(i), i);
            if (result == BALL) {
                ball += 1;
            }
            if (result == STRIKE) {
                strike += 1;
            }
        }
        return List.of(ball, strike);
    }

    public int judgeNumber(int userNumber, int index) {
        if (answerList.get(index) == userNumber) {
            return STRIKE;
        }
        if (answerList.contains(userNumber)) {
            return BALL;
        }
        return NOTHING;
    }
    public void setAnswerList(List<Integer> answerList) {
        this.answerList = answerList;
    }
    public List<Integer> getAnswerList() {
        return answerList;
    }
}
