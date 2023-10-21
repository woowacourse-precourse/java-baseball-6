package baseball;

import java.util.List;

import static baseball.constant.NumberConstant.*;
import static baseball.constant.TextConstant.*;

public class Discriminator {

    private int ball;
    private int strike;
    private int nothing;
    private List<Integer> computerNumber;
    private List<Integer> guessNumber;

    private Discriminator(final int ball, final int strike, final int nothing,
                         final List<Integer> computerNumber, final List<Integer> guessNumber) {
        this.ball = ball;
        this.strike = strike;
        this.nothing = nothing;
        this.computerNumber = computerNumber;
        this.guessNumber = guessNumber;
    }

    public static Discriminator create(final List<Integer> computerNumber, final List<Integer> guessNumber) {
        return new Discriminator(ZERO, ZERO, ZERO, computerNumber, guessNumber);
    }

    public boolean match(final int computerNumberIdx, final int guessNumberIdx) {
        int computerNumberOne = computerNumber.get(computerNumberIdx);
        int myNumberOne = guessNumber.get(guessNumberIdx);

        if (computerNumberOne == myNumberOne) {
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
        System.out.print(ball + BALL);
        System.out.print(strike + STRIKE);
        System.out.println(nothing + NOTHING);
    }

    public void strike() {
        strike += ONE;
    }

    public void ball() {
        ball += ONE;
    }

    public void nothing() {
        nothing += ONE;
    }

    public int getStrike() {
        return strike;
    }
}
