package baseball.service;

import baseball.domain.BaseballGame;
import baseball.domain.GameResult;

public class GameService {

    private final BaseballGame baseballGame;

    public GameService(BaseballGame baseballGame) {
        this.baseballGame = baseballGame;
    }

    public void numbersInit() {
        baseballGame.init();
    }

    public GameResult getResult(String inputNumbers) {
        return baseballGame.compare(inputNumbers);
    }
}
