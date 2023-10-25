package baseball;

import baseball.util.BallStrikeCalculator;
import baseball.util.RandomNumberGenerator;

import baseball.validation.GameInputValidator;
import baseball.validation.PlayOrStopInputValidator;

public class AppConfig {
    public GameInputValidator gameInputValidator() {
        return new GameInputValidator();
    }

    public PlayOrStopInputValidator playOrStopInputValidator() {
        return new PlayOrStopInputValidator();
    }

    public RandomNumberGenerator randomNumberGenerator() {
        return new RandomNumberGenerator();
    }

    public BallStrikeCalculator ballStrikeCalculator() {
        return new BallStrikeCalculator();
    }
}
