package baseball.domain;

import java.util.List;

public class Result {
    private int ball;
    private int strike;

    public String compareInputAnswerToRandomNumbers(List<Integer> inputAnswer, List<Integer> randomNumbers) {
        ball = 0;
        strike = 0;

        for (int i = 0; i < inputAnswer.size(); i++) {
            if (inputAnswer.get(i).equals(randomNumbers.get(i))) {
                strike++;
            } else if (randomNumbers.contains(inputAnswer.get(i))) {
                ball++;
            }
        }
        return getOutputMessage();
    }

    private String getOutputMessage() {
        if (ball > 0 && strike > 0) {
            return ball + "볼 " + strike + "스트라이크";
        } else if (ball > 0) {
            return ball + "볼";
        } else if (strike > 0) {
            return strike + "스트라이크";
        }
        return "낫싱";
    }

    public boolean isGameOver() {
        if (strike == 3) {
            ball = 0;
            strike = 0;
            return true;
        }
        ball = 0;
        strike = 0;
        return false;
    }
}