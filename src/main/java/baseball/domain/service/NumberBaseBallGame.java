package baseball.domain.service;

import baseball.domain.model.BaseballNumber;
import baseball.domain.model.GameStatus;
import baseball.domain.util.RandomNumberGenerator;
import java.util.function.Consumer;

public class NumberBaseBallGame {

    private BaseballNumber randomNumber;
    private final NumberBaseballScoreEvaluator numberBaseballScoreEvaluator;
    private final RandomNumberGenerator<String> randomNumberGenerator;

    public NumberBaseBallGame(RandomNumberGenerator<String> generator,
                              NumberBaseballScoreEvaluator evaluator) {
        this.randomNumberGenerator = generator;
        this.numberBaseballScoreEvaluator = evaluator;
        initRandomNumber();
    }

    public RoundEvaluationResult evaluateRound(BaseballNumber baseballNumber) {

        String roundResult = numberBaseballScoreEvaluator.evaluate(
                new BaseballScoreCounter(randomNumber, baseballNumber)
        );
        GameStatus status = GameStatus.of(roundResult);
        return new RoundEvaluationResult(status, roundResult);
    }

    private void initRandomNumber() {
        randomNumber = new BaseballNumber(randomNumberGenerator.generateRandomNumbers());
    }

    public void restart() {
        initRandomNumber();
    }
}
