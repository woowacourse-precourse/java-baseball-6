package baseball.controller;

import baseball.domain.Computer;
import baseball.service.GameService;
import baseball.utils.GameMessage;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;

public class BaseballGame {
    private final GameService gameService;
    private final static String exitNumber = "2";
    private static boolean endOrNot = false;


    public BaseballGame() {
        gameService = new GameService();
    }

    public void startGame() {
        initStartGame();
        while (endOrNot) {
            startOneGame();
            exitGame();
        }
        System.out.println(GameMessage.EXIT_GAME.getMessage());
    }

    private void startOneGame() {
        Computer computer = new Computer();
        boolean oneGameFinished = false;
        List<Integer> computerNumber = computer.getComputerNumber();
        while (!oneGameFinished) {
            System.out.print(GameMessage.REQUIRED_INPUT_NUMBER.getMessage());
            List<Integer> userNumber = gameService.parsingInputNumber(InputView.Input());
            List<Integer> gameResult = gameService.playGame(computerNumber, userNumber);
            if (OutputView.outputResult(gameResult)) {
                oneGameFinished = true;
            }
        }
    }

    private void initStartGame() {
        System.out.println(GameMessage.BASEBALL_START.getMessage());
        endOrNot = true;
    }

    private void exitGame() {
        System.out.println(GameMessage.DECIDE_CONTINUE_OR_EXIT.getMessage());
        if (InputView.Input().equals(exitNumber)) {
            endOrNot = false;
        }
    }
}
