package baseball.controller;

import static baseball.model.Restart.isRestart;

import baseball.model.Computer;
import baseball.model.NumberList;
import baseball.model.Restart;
import baseball.view.InputView;
import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.Console;

public class BaseballGameController extends GameController {
    Computer computer;

    public BaseballGameController(boolean isRunning) {
        super(isRunning);
        computer = new Computer();
    }

    public void start() {
        do {
            startGame();
            askRestart();
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

    private void askRestart() {
        isRunning = isRestart(scanRestart());
    }

    private NumberList scanGuess() {
        return new NumberList(InputController.scanGuess());
    }

    private Restart scanRestart() {
        return new Restart(InputController.scanRestart());
    }

    private static class InputController {
        public static String scanGuess() {
            InputView.printEnterGuess();
            return Console.readLine();
        }

        public static String scanRestart() {
            InputView.printEnterRestart();
            return Console.readLine();
        }
    }
}