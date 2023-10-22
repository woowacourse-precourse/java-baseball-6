package baseball;

import java.util.List;

import static baseball.constant.NumberConstant.*;
import static baseball.constant.TextConstant.*;

public class Discriminator {

    private int ball;
    private int strike;
    private List<Integer> computerNumber;
    private List<Integer> guessNumber;

    private Discriminator(final int ball, final int strike,
                         final List<Integer> computerNumber, final List<Integer> guessNumber) {
        this.ball = ball;
        this.strike = strike;
        this.computerNumber = computerNumber;
        this.guessNumber = guessNumber;
    }

    public static Discriminator create(final List<Integer> computerNumber, final List<Integer> guessNumber) {
        return new Discriminator(ZERO, ZERO, computerNumber, guessNumber);
    }

    public boolean match(final int computerNumberIdx, final int guessNumberIdx) {
        int computerNumberOne = computerNumber.get(computerNumberIdx);
        int guessNumberOne = guessNumber.get(guessNumberIdx);

        if (computerNumberOne == guessNumberOne) {
            if (computerNumberIdx == guessNumberIdx) {
                strike();
            } else {
                ball();
            }

            return true;
        }

        return false;
    }

    public void printGuessResult() {
        if (ball == 0 && strike == 0) {
            System.out.println(NOTHING);
        } else if (ball == 0) {
            System.out.println(strike + STRIKE);
        } else if (strike == 0) {
            System.out.println(ball + BALL);
        } else {
            System.out.print(ball + BALL);
            System.out.println(strike + STRIKE);
        }
    }

    public void strike() {
        strike += ONE;
    }

    public void ball() {
        ball += ONE;
    }

    public int getStrike() {
        return strike;
    }
}
