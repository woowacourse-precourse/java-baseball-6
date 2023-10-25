package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class ResultCount {
    private boolean isMatched;
    int strike;
    int ball;

    private ResultCount(boolean isMatched, int strike, int ball) {
        this.isMatched = isMatched;
        this.strike = strike;
        this.ball = ball;
    }

    public boolean isMatched() {
        return isMatched;
    }

    public static ResultCount fromUserInput(String userInput, List<Integer> answerNumber) {
        int strike = 0;
        int ball = 0;
        List<Integer> userInputList = new ArrayList<>();
        for (char c : userInput.toCharArray()) {
            userInputList.add(Character.getNumericValue(c));
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (userInputList.get(i).equals(answerNumber.get(j))) {
                    if (i == j) {
                        strike++;
                    } else {
                        ball++;
                    }
                }
            }
        }

        boolean isMatched = strike > 0 || ball > 0;
        return new ResultCount(isMatched, strike, ball);
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResultCount that = (ResultCount) o;
        return isMatched == that.isMatched &&
               strike == that.strike &&
               ball == that.ball;
    }

    public int hashCode() {
        return Objects.hash(isMatched, strike, ball);
    }
}