package baseball.controller;

import baseball.model.Computer;
import baseball.model.GameStatus;
import baseball.model.NumberList;
import baseball.view.InputView;
import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.Console;

public class BaseballGameController extends GameController {
    private final Computer computer;

    public BaseballGameController(boolean isRunning) {
        super(isRunning);
        computer = new Computer();
    }

    public void start() {
        do {
            startGame();
            askRestartGame();
        } while (isRunning);
    }

    public void startGame() {
        OutputView.printStartGameMessage();

        NumberList guess;
        computer.createRandomAnswer();
        do {
            guess = scanGuess();
            OutputView.printHintMessage(computer.calculateHint(guess));
        } while (!computer.isAnswer(guess));
        OutputView.printSuccessAndEndGameMessage();
    }

    private void askRestartGame() {
        isRunning = GameStatus.isRestart(scanStatus());
    }

    private NumberList scanGuess() {
        return NumberList.stringToNumberList(InputController.scanGuess());
    }

    private GameStatus scanStatus() {
        return GameStatus.stringToGameStatus(InputController.scanStatus());
    }

    private static class InputController {
        public static String scanGuess() {
            InputView.printEnterGuess();
            return Console.readLine();
        }

        public static String scanStatus() {
            InputView.printEnterStatus();
            return Console.readLine();
        }
    }
}