package baseball.service;

import baseball.domain.GameNumbers;

public class GameService {

    private final GameNumbers gameNumbers;

    public GameService(GameNumbers gameNumbers) {
        this.gameNumbers = gameNumbers;
    }

    public void numbersInit() {
        gameNumbers.init();
    }

    public void getResult(String inputNumbers) {

    }
}
