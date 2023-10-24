package baseball.controller;

import static baseball.properties.Properties.*;

import baseball.model.Balls;
import java.util.List;

import baseball.model.GameResult;
import baseball.service.GameService;
import baseball.view.View;

import camp.nextstep.edu.missionutils.Console;

public class GameController {
    private GameService gameService;

    public void runGame() {
        boolean onGame = true;

        View.gameStart();
        initGame();
        while (onGame) {
            List<Integer> userInput = getUserInput();
            GameResult gameResult = getResult(userInput);
            onGame = endGame(gameResult);
        }
    }

    private void initGame() {
        this.gameService = new GameService(Balls.createRandomBalls(GAME_SIZE, DIGIT_START, DIGIT_END));
    }

    private List<Integer> getUserInput() {
        View.gameInput();
        String userInputString = Console.readLine();
        return gameService.parseInput(userInputString);
    }

    private GameResult getResult(List<Integer> userInputNumbers) {
        GameResult gameResult = gameService.calculateGameResult(userInputNumbers);
        View.gameResult(gameResult);
        return gameResult;
    }

    private boolean endGame(GameResult gameResult) {
        if (!gameResult.isAnswer(GAME_SIZE)) {
            return true;
        }
        View.gameEnd(GAME_SIZE);
        String responseRetry = Console.readLine();
        if (responseRetry.equals(RETRY_GAME)) {
            initGame();
            return true;
        }
        return false;
    }
}
