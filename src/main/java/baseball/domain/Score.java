package baseball.domain;

import java.util.List;

public class Score {

    private int strike;
    private int ball;

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
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
}
