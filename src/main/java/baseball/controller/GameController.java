package baseball.controller;

import static baseball.util.Constants.CONTINUE;
import static baseball.util.Constants.EXIT;
import static baseball.util.Constants.WRONG;

import baseball.Service.ComputerService;
import baseball.Service.GameService;
import baseball.Service.UserService;
import java.util.List;

public class GameController {
    private final ComputerService computerService = new ComputerService();
    private final GameService gameService = new GameService();
    private final UserService userService = new UserService();

    public void run() {
        initGame();
        startGame();
        endGame();
    }

    public void initGame() {
        gameService.init();
        computerService.init();
    }

    public void startGame() {
        int result = WRONG;
        while (result == WRONG) {
            List<Integer> userAnswer = userService.inputAnswer();
            List<Integer> resultList = computerService.compareAnswer(userAnswer);
            result = gameService.analyze(resultList);
        }
    }

    public void endGame() {
        String select = gameService.end();

        if (select.equals(CONTINUE)) {
            run();
        }
        if (select.equals(EXIT)) {
            gameService.exit();
        }
        if (!select.equals(CONTINUE) && !select.equals(EXIT)) {
            throw new IllegalArgumentException();
        }
    }
}
