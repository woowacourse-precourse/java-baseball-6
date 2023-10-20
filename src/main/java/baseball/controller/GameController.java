package baseball.controller;

import static baseball.properties.Properties.DIGIT_END;
import static baseball.properties.Properties.DIGIT_START;
import static baseball.properties.Properties.GAME_SIZE;

import baseball.service.GameService;
import baseball.utils.RandomUtils;
import baseball.view.View;

public class GameController {
    private GameService gameService;

    public void runGame() {
        View.gameStart();
        initGame();
    }


    public void initGame() {
        this.gameService = new GameService(RandomUtils.getRandomNumbers(GAME_SIZE, DIGIT_START, DIGIT_END));
        //getUserInput();
    }
}
