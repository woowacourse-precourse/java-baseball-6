package baseball;

import java.util.ArrayList;
import java.util.List;

public class Referee {
    private List<Integer> answerList;
    public Referee(List<Integer> answerList) {
        this.answerList = new ArrayList<>(answerList);
    }

    public List<Integer> judgeUserInput(List<Integer> userInput) {
        int ball = 0;
        int strike = 0;
        for (int i = 0; i < answerList.size(); i++) {
            final int result = judgeNumber(userInput.get(i), i);
            if (result == 1) {
                ball += 1;
            }
            if (result == 2) {
                strike += 1;
            }
        }
        if (ball == 0 && strike == 0) {
            return null;
        }
        return List.of(ball, strike);
    }

    public int judgeNumber(int userNumber, int index) {
        if (answerList.get(index) == userNumber) {
            return 2;
        }
        if (answerList.contains(userNumber)) {
            return 1;
        }
        return 0;
    }
}
