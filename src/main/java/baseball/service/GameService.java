package baseball.service;

import baseball.domain.BaseballGame;

public class GameService {

    private final BaseballGame baseballGame;

    public GameService(BaseballGame baseballGame) {
        this.baseballGame = baseballGame;
    }

    public void numbersInit() {
        baseballGame.init();
    }

    public void getResult(String inputNumbers) {

    }
}
