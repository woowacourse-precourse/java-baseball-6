package baseball.domain;

import java.util.List;

public class Score {

    private int strike;
    private int ball;
    private ResultState resultState;

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public ResultState getResultState() {
        return resultState;
    }

    public int checkStrike(String input, List<Integer> computer) {
        strike = 0;
        for (int i = 0; i < input.length(); i++) {
            int inputDigit = Character.getNumericValue(input.charAt(i));
            if (inputDigit == computer.get(i)) {
                strike++;
            }
        }
        return strike;
    }

    public int checkBall(String input, List<Integer> computer) {
        ball = 0;
        for (int i = 0; i < input.length(); i++) {
            int inputDigit = Character.getNumericValue(input.charAt(i));
            if (inputDigit != computer.get(i) && computer.contains(inputDigit)) {
                ball++;
            }
        }
        return ball;
    }

    public void setResultState(int ball, int strike) {
        if (strike == 3) {
            resultState = ResultState.THREE_STRIKE;
        } else if (ball == 0 && strike == 0) {
            resultState = ResultState.NOTHING;
        } else if (ball == 0) {
            resultState = ResultState.STRIKE;
        } else if (strike == 0) {
            resultState = ResultState.BALL;
        } else {
            resultState = ResultState.BALL_AND_STRIKE;
        }
    }
}
