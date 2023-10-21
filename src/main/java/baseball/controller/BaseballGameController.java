package baseball.controller;

import baseball.model.Computer;
import baseball.model.NumberList;
import baseball.model.Restart;
import baseball.utils.Convert;
import baseball.validator.Validator;
import baseball.view.InputView;
import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.Console;

public class BaseballGameController {
    public void startGame() {
        Computer computer = new Computer();
        NumberList guess;

        computer.createRandomAnswer();
        do {
            guess = guessing();
            OutputView.printHintMessage(computer.calculateHint(guess));
        } while (!computer.isAnswer(guess));
        OutputView.printSuccessAndEndGameMessage();
    }

    private NumberList guessing() {
        return Convert.stringToNumberList(InputController.scanGuess());
    }

    public boolean whetherRestart() {
        Restart restart = new Restart(Integer.parseInt(InputController.scanRestart()));
        return restart.whetherRestart();
    }

    private static class InputController {
        public static String scanGuess() {
            InputView.printEnterGuess();
            String userInput = Console.readLine();
            validateGuess(userInput);
            return userInput;
        }

        public static String scanRestart() {
            InputView.printEnterRestart();
            String userInput = Console.readLine();
            validateRestart(userInput);
            return userInput;
        }

        private static void validateGuess(String guess) {
            Validator.validateNull(guess);
            Validator.validateSize(guess, 3);
        }

        private static void validateRestart(String restart) {
            Validator.validateNull(restart);
            Validator.validateSize(restart, 1);
        }
    }
}