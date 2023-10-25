package baseball.controller;

import baseball.domain.Computer;
import baseball.service.GameService;
import baseball.utils.GameMessage;
import baseball.validation.GameExitValidation;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;

public class BaseballGame {
    private final GameService gameService;
    private final static String exitNumber = "2";
    private static boolean endOrNot = false;
    private static List<Integer> userNumber;
    private static List<Integer> computerNumber;

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
        oneGamePreparation();
        while (true) {
            if (oneGameProgress()) {
                break;
            }
        }
    }

    public void oneGamePreparation() {
        Computer computer = new Computer();
        computerNumber = computer.getComputerNumber();
    }

    public boolean oneGameProgress() {
        userNumber = inputUserNumber();
        List<Integer> gameResult = gameService.playGame(computerNumber, userNumber);
        return OutputView.outputResult(gameResult);
    }

    private List<Integer> inputUserNumber() {
        System.out.print(GameMessage.REQUIRED_INPUT_NUMBER.getMessage());
        return gameService.parsingInputNumber(InputView.Input());
    }

    private void initStartGame() {
        System.out.println(GameMessage.BASEBALL_START.getMessage());
        endOrNot = true;
    }

    private void exitGame() {
        System.out.println(GameMessage.DECIDE_CONTINUE_OR_EXIT.getMessage());
        String exitAnswer = InputView.Input();
        GameExitValidation.validateExitAnswer(exitAnswer);
        if (exitAnswer.equals(exitNumber)) {
            endOrNot = false;
        }
    }
}
