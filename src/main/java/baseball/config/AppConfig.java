package baseball.config;

import baseball.controller.GameController;
import baseball.model.random.NumberGenerator;
import baseball.model.random.RandomNumberGenerator;
import baseball.service.BaseballGame;

public class AppConfig {
    public GameController gameController(){
        return new GameController(baseballGame());
    }

    public BaseballGame baseballGame() {
        return new BaseballGame(numberGenerator());
    }

    public NumberGenerator numberGenerator() {
        return new RandomNumberGenerator();
    }
}
