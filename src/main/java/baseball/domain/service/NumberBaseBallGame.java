package baseball.domain.service;

import baseball.domain.model.GameStatus;
import baseball.domain.util.RandomNumberGenerator;
import java.util.Objects;

public class NumberBaseBallGame {

    private String randomNumber;
    private final String THREE_STRIKE = "3스트라이크";

    public NumberBaseBallGame(RandomNumberGenerator generator) {
        this.randomNumber = generator.generateNumbers();
    }

    public RoundEvaluationResult evaluateRound(String input) {
        System.out.println( "random :" + randomNumber);
        String roundResult = new NumberBaseballScoreEvaluator(randomNumber,
                input).evaluate();
        if (Objects.equals(roundResult, THREE_STRIKE)) {
            return new RoundEvaluationResult(GameStatus.GAME_OVER, roundResult);
        }
        return new RoundEvaluationResult(GameStatus.CONTINUE, roundResult);
    }

    public void initRandomNumber() {
        randomNumber = new RandomNumberGenerator().generateNumbers();
    }
}
