package baseball.controller;

import static baseball.util.Constants.CONTINUE;
import static baseball.util.Constants.CORRECT_ANSWER;
import static baseball.util.Constants.EXIT;
import static baseball.util.Constants.WRONG_ANSWER;

import baseball.Service.ComputerService;
import baseball.Service.GameService;
import baseball.Service.UserService;
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
        gameService.init();//출력
        computerService.init(); //난수생성해서 객체 생성
    }

    public void startGame() {
        List<Integer> userAnswer = userService.readAnswer();
        List<Integer> resultList = computerService.compareAnswer(userAnswer);
        int result = gameService.analyze(resultList);
        if (result == CORRECT_ANSWER) {
            winGame();
        }
        if (result == WRONG_ANSWER) {
            startGame();
        }
    }

    public void winGame() {
        String select = gameService.success();

        if (select.equals(CONTINUE)) {
            start();
        }
        if (select.equals(EXIT)) {
            gameService.end();
        }
        if (!select.equals(CONTINUE) && !select.equals(EXIT)) {
            throw new IllegalArgumentException();
        }
    }
}
