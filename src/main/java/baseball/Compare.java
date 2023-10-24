package baseball;

import java.util.ArrayList;
import java.util.List;

public class Compare {
    private static final int ANSWER_LENGTH = 3;
    private final List<Integer> randomNumberList;

    public Compare(List<Integer> randomNumberList) {
        this.randomNumberList = randomNumberList;
    }

    public List<Integer> compareList(List<Integer> userInputList) {
        int count = 0;
        int ball = 0;
        int strike = 0;
        List<Integer> answerList = new ArrayList<>();
        for (int i = 0; i < ANSWER_LENGTH; i++) {
            if (randomNumberList.contains(userInputList.get(i))) {
                count++;
            }
        }
        for (int i = 0; i < ANSWER_LENGTH; i++) {
            if (randomNumberList.get(i) == userInputList.get(i)) {
                count--;
                strike++;
            }
            if (count == 0) {
                break;
            }
        }
        if (count != 0) {
            ball = count;
        }
        answerList.add(ball);
        answerList.add(strike);
        return answerList;
    }

    public boolean success(List<Integer> result) {
        if (result.get(1) == 3) {
            return false;
        }
        return true;
    }
}
