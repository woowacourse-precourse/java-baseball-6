package baseball;

import java.util.List;

import static baseball.constant.NumberConstant.*;
import static baseball.constant.TextConstant.*;

public class Discriminator {

    private int ball;
    private int strike;
    private int nothing;
    private List<Integer> computerNumber;
    private List<Integer> myNumber;

    private Discriminator(final int ball, final int strike, final int nothing,
                         final List<Integer> computerNumber, final List<Integer> myNumber) {
        this.ball = ball;
        this.strike = strike;
        this.nothing = nothing;
        this.computerNumber = computerNumber;
        this.myNumber = myNumber;
    }

    public static Discriminator create(final List<Integer> computerNumber, final List<Integer> myNumbers) {
        return new Discriminator(ZERO, ZERO, ZERO, computerNumber, myNumbers);
    }

    public boolean match(final int computerNumberIdx, final int myNumberIdx) {
        int computerNumberOne = computerNumber.get(computerNumberIdx);
        int myNumberOne = myNumber.get(myNumberIdx);

        if (computerNumberOne == myNumberOne) {
            if (computerNumberIdx == myNumberIdx) {
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
