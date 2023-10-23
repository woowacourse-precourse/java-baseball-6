package baseball.model;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class BaseBallGame {
    private final BaseBallNumber computerNumber;
    private Boolean isCorrect;
    public BaseBallGame() {
        computerNumber = BaseBallNumber.generateRandomNumbers();
        isCorrect = Boolean.FALSE;
    }

    public BallCount play(String inputAnswer) {
        BaseBallNumber inputBaseBallNumber = BaseBallNumber.parse(inputAnswer);

        return calculateStrikeAndBall(inputBaseBallNumber);
    }

    public Boolean isFinished() {
        return isCorrect;
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

        checkCorrect(computerNumber.getBaseBallNumberCount(), strike.get(), ball.get());
        return new BallCount(strike.get(), ball.get());
    }

    private void checkCorrect(int ballCount, int strike, int ball) {
        if(strike == ballCount && ball == 0) isCorrect = true;
    }
}
