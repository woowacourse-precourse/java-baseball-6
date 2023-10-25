package baseball.model;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class BallCount {

    private final int strike;
    private final int ball;

    private BallCount(final BaseBallNumber computerNumber, final BaseBallNumber inputNumber) {

        AtomicInteger strikeCount = new AtomicInteger(0);
        AtomicInteger ballCount = new AtomicInteger(0);

        calculateStrikeAndBall(computerNumber, inputNumber, strikeCount, ballCount);

        this.strike = strikeCount.get();
        this.ball = ballCount.get();
    }

    public static BallCount calculate(BaseBallNumber computerNumber, BaseBallNumber inputNumber) {
        return new BallCount(computerNumber, inputNumber);
    }

    private void calculateStrikeAndBall(BaseBallNumber computerNumber,
                                               BaseBallNumber inputNumber,
                                               AtomicInteger strike,
                                               AtomicInteger ball) {

        computerNumber.compare((computerNum, computerIndex) ->
                inputNumber.compare((inputNum, inputIndex) -> {
                    if(!Objects.equals(computerNum, inputNum)) return;
                    if(computerIndex.equals(inputIndex)) {
                        strike.getAndIncrement();
                    }
                    else {
                        ball.getAndIncrement();
                    }
                })
        );
    }
}
