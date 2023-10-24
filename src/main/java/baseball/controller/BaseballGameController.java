package baseball.controller;

import baseball.model.Computer;
import baseball.model.GameStatus;
import baseball.model.NumberList;
import baseball.validator.Validator;
import baseball.view.InputView;
import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.Console;
import java.util.HashSet;
import java.util.Set;

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
            String userInput = Console.readLine();
            validateGuess(userInput);
            return userInput;
        }

        public static String scanStatus() {
            InputView.printEnterStatus();
            String userInput = Console.readLine();
            validateStatus(userInput);
            return userInput;
        }

        private static void validateGuess(String guess) {
            Validator.validateNull(guess);
            Validator.validateSize(guess, 3);
            validateIsInRange(guess, 1, 9);
            validateRepeatedNumber(guess);
        }

        private static void validateIsInRange(String guess, int startInclusive, int endInclusive) {
            for (int i = 0; i < guess.length(); i++) {
                Validator.validateInRange(guess.charAt(i) - '0', startInclusive, endInclusive);
            }
        }

        private static void validateRepeatedNumber(String guess) {
            Set<Character> set = new HashSet<>();
            for (int i = 0; i < guess.length(); i++) {
                set.add(guess.charAt(i));
            }
            if (set.size() != guess.length()) {
                throw new IllegalArgumentException("중복된 원소가 있습니다.");
            }
        }

        private static void validateStatus(String status) {
            validateIsInRange(status, 1, 2);
        }
    }
}