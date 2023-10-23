package baseball.controller;

import static baseball.util.Constants.CONTINUE;
import static baseball.util.Constants.CORRECT_ANSWER;
import static baseball.util.Constants.EXIT;
import static baseball.util.Constants.WRONG_ANSWER;

import baseball.Service.ComputerService;
import baseball.Service.GameService;
import baseball.Service.UserService;
import java.util.HashMap;
import java.util.List;

public class GameController {
    private final ComputerService computerService = new ComputerService();
    private final GameService gameService = new GameService();
    private final UserService userService = new UserService();

    public void start() {
        initGame();
        startGame();
    }

    public void initGame() {
        gameService.init();
        computerService.init();
    }

    public void startGame() {
        String userAnswerString = userService.waitInput();
        List<Integer> userAnswer = userService.setInput(userAnswerString);
        System.out.println(userAnswer);
        HashMap<Integer, Integer> resultMap = computerService.compareAnswer(userAnswer);
        int result = gameService.determine(resultMap);
        if (result == CORRECT_ANSWER) {
            endGame();
        }
        if (result == WRONG_ANSWER) {
            startGame();
        }
    }

    public void endGame() {
        String select = gameService.end();

        if (select.equals(CONTINUE)) {
            start();
        }
        if (select.equals(EXIT)) {
            return;
        }
        if (!select.equals(CONTINUE) && !select.equals(EXIT)) {
            throw new IllegalArgumentException();
        }
    }
}
