package baseball.controller;

import static baseball.util.Constants.CONTINUE;
import static baseball.util.Constants.CORRECT;
import static baseball.util.Constants.EXIT;
import static baseball.util.Constants.WRONG;

import baseball.Service.ComputerService;
import baseball.Service.GameService;
import baseball.Service.UserService;
import baseball.model.Player;
import java.util.List;

public class GameController {
    private final ComputerService computerService = new ComputerService();
    private final GameService gameService = new GameService();
    private final UserService userService = new UserService();
    private Player player;

    public void run() {
        initGame();
        startGame();
    }

    private void initGame() {
        gameService.init(); // strike=0 ball=0
        player = computerService.init(); // create random 3 numbers
    }

    private void startGame() {
        List<Integer> userAnswer = userService.enterAnswer();
        int result = gameService.compute(player, userAnswer);
        if (result == WRONG) {
            startGame();
        }
        if (result == CORRECT) {
            endGame();
        }
    }

    private void endGame() {
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
