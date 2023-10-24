package baseball;

import static baseball.GameNumber.*;

public class Result {
    int ball = 0;
    int strike = 0;

    public Result(int ball, int strike) {
        this.ball = ball;
        this.strike = strike;
    }

    public boolean isAllCorrect() {
        return this.strike == NUMBER_LIMIT;
    }

    public static Result calculate(String input, String answer) {
        int strike = 0;
        int ball = 0;
        for(int i=0; i<input.length(); i++) {
            if (input.charAt(i) == answer.charAt(i)) strike++;
            else if (answer.contains(String.valueOf(input.charAt(i)))) ball++;
        }
        return new Result(ball, strike);
    }

    @Override
    public String toString() {
        if (strike == NUMBER_LIMIT) { return "3스트라이크"; }
        else if (ball == 0 && strike == 0) { return "낫싱"; }
        else { return ball+"볼" + " " + strike + "스트라이크"; }
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }
}
