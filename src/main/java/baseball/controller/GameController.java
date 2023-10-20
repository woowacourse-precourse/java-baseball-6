package baseball.controller;

import static baseball.properties.Properties.*;

import java.util.List;

import baseball.service.GameService;
import baseball.utils.RandomUtils;
import baseball.view.View;

import camp.nextstep.edu.missionutils.Console;

public class GameController {
    private GameService gameService;

    public void runGame() {
        View.gameStart();
        initGame();
    }

    public void initGame() {
        this.gameService = new GameService(RandomUtils.getRandomNumbers(GAME_SIZE, DIGIT_START, DIGIT_END));
        getUserInput();
    }

    public void getUserInput() {
        View.gameInput();
        String userInputString = Console.readLine();
        List<Integer> userInpuNumbers = gameService.parseInput(userInputString);
    }
}
