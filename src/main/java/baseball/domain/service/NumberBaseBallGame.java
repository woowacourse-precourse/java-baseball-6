package baseball.domain.service;

import baseball.domain.model.GameStatus;
import baseball.domain.util.RandomNumberGenerator;
import java.util.Objects;

public class NumberBaseBallGame {

    private String randomNumber;
    private final String THREE_STRIKE = "3스트라이크";
    private final NumberBaseballScoreEvaluator numberBaseballScoreEvaluator;
    private final RandomNumberGenerator randomNumberGenerator;

    public NumberBaseBallGame(RandomNumberGenerator generator,
                              NumberBaseballScoreEvaluator numberBaseballScoreEvaluator) {
        this.randomNumberGenerator = generator;
        this.numberBaseballScoreEvaluator = numberBaseballScoreEvaluator;
        initRandomNumber();
    }

    public RoundEvaluationResult evaluateRound(String input) {
        String roundResult = numberBaseballScoreEvaluator.evaluate(input, randomNumber);
        GameStatus status = GameStatus.of(roundResult);
        return new RoundEvaluationResult(status, roundResult);
    }

    public void initRandomNumber() {
        randomNumber = randomNumberGenerator.generateNumbers();
    }
}
