package baseball.controller;

import baseball.model.Computer;
import baseball.model.NumberList;
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
        String guessString = InputController.scanUsersGuess();
        return Convert.stringToNumberList(guessString);
    }

    private static class InputController {
        public static String scanUsersGuess() {
            InputView.printEnterGuess();
            String userInput = Console.readLine();
            validateUsersGuess(userInput);
            return userInput;
        }

        private static void validateUsersGuess(String guess) {
            Validator.validateNull(guess);
        }
    }
}