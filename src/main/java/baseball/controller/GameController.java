package baseball.controller;

import baseball.model.ComputerNumber;
import baseball.model.UserNumber;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

public class GameController {
    private static List<Integer> computerNumber;
    private static List<Integer> userNumber;
    private static HintCalculator hintCalculator;

    public static void proceedGame() {
        showStartMessage();
        boolean restartValue = true;
        while (restartValue) {
            setComputerNumber();
            playGame();
            restartValue = checkRestart(getRestartValue());
        }
    }

    private static void playGame() {
        boolean successValue = false;
        while (!successValue) {
            setUserNumber();
            setCalculator();
            showHint();
            successValue = checkSuccess();
        }
        showEndMessage();
    }

    private static void setCalculator() {
        hintCalculator = new HintCalculator(userNumber, computerNumber);
    }

    private static void showEndMessage() {
        OutputView.printEndMessage();
    }

    private static boolean checkRestart(String restartValue) {
        if (restart(restartValue)) {
            return true;
        } else if (quit(restartValue)) {
            return false;
        }
        throw new IllegalArgumentException("1과 2중에 입력해야 합니다.");
    }

    private static String getRestartValue() {
        return InputView.inputRestartValue();
    }

    private static boolean quit(String restartValue) {
        return restartValue.equals("2");
    }

    private static boolean restart(String restartValue) {
        return restartValue.equals("1");
    }

    private static boolean checkSuccess() {
        return hintCalculator.isThreeStrike();
    }

    private static void showHint() {
        OutputView.printHint(getHintMessage());
    }

    private static String getHintMessage() {
        return hintCalculator.getHintString();
    }

    private static void setUserNumber() {
        UserNumber user = new UserNumber(validate(getUserNumber()));
        userNumber = user.getNumber();
    }

    private static String validate(String userNumber) {
        return NumberValidator.validateString(userNumber);
    }

    private static String getUserNumber() {
        return InputView.inputUserNumber();
    }

    private static void setComputerNumber() {
        ComputerNumber computer = new ComputerNumber();
        computerNumber = computer.getNumber();
    }

    private static void showStartMessage() {
        OutputView.printStartMessage();
    }
}
