package baseball.controller;

import baseball.model.ComputerNumber;
import baseball.model.UserNumber;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {
    private static ComputerNumber computerNumber;
    private static UserNumber userNumber;
    private static HintCalculator hintCalculator;

    public static void proceedGame() {
        showStartMessage();
        boolean restartValue = true;
        while(restartValue){
            setComputerNumber();
            playGame();
            restartValue = checkRestart(getRestartValue());
        }
    }

    private static void playGame() {
        boolean isSuccessValue = false;
        while(!isSuccessValue){
            setUserNumber();
            showHint();
            isSuccessValue = checkSuccess();
        }
        showEndMessage();
    }

    private static void showEndMessage() {
        OutputView.printEndMessage();
    }

    private static boolean checkRestart(String restartValue) {
        if(restart(restartValue)){
            return true;
        }
        else if(quit(restartValue)){
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
        hintCalculator = new HintCalculator(userNumber.getNumber(), computerNumber.getNumber());
        OutputView.printHint(getHintMessage());
    }

    private static String getHintMessage() {
        return hintCalculator.getHintString();
    }

    private static void setUserNumber() {
        userNumber = new UserNumber(getUserNumber());
    }

    private static String getUserNumber() {
        return InputView.inputUserNumber();
    }

    private static void setComputerNumber() {
        computerNumber = new ComputerNumber();
    }

    private static void showStartMessage() {
        OutputView.printStartMessage();
    }
}
