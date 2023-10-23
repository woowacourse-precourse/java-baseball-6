package baseball.model;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class BaseBallGame {
    private final BaseBallNumber computerNumber;
    public BaseBallGame(int digit) {
        computerNumber = BaseBallNumber.generateRandomNumbers(digit);
    }
    private BallCount calculateStrikeAndBall(BaseBallNumber inputBaseBallNumber) {
        AtomicInteger strike = new AtomicInteger(0);
        AtomicInteger ball = new AtomicInteger(0);

        computerNumber.calculate((targetNumber, computerIndex) ->
                inputBaseBallNumber.calculate((inputNumber, inputIndex) -> {
                    if(!Objects.equals(targetNumber, inputNumber)) return;

                    if(computerIndex.equals(inputIndex)) {
                        strike.getAndIncrement();
                    }
                    else {
                        ball.getAndIncrement();
                    }
                })
        );

        return new BallCount(strike.get(), ball.get());
    }

    public BallCount play(String inputAnswer) {
        BaseBallNumber inputBaseBallNumber = BaseBallNumber.parse(inputAnswer);

        return calculateStrikeAndBall(inputBaseBallNumber);
    }

    public boolean isCorrectedAnswer(int digit, BallCount ballCount) {
        return ballCount.getStrike() == digit && ballCount.getBall() == 0;
    }
}
