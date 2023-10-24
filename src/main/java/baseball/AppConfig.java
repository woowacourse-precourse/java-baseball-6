package baseball;

import baseball.util.BallStrikeCalculator;
import baseball.util.RandomNumberGenerator;
import baseball.validation.GameInputValidator;
import baseball.validation.PlayOrStopInputValidator;

public class AppConfig {
    GameInputValidator gameInputValidator = new GameInputValidator();
    PlayOrStopInputValidator playOrStopInputValidator = new PlayOrStopInputValidator();
    RandomNumberGenerator randomNumberGenerator =new RandomNumberGenerator();
    BallStrikeCalculator ballStrikeCalculator = new BallStrikeCalculator();
}
