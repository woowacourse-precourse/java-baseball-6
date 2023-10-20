package baseball.controller;

import baseball.model.ComputerNumber;
import baseball.model.UserNumber;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {
    private static ComputerNumber computerNumber;
    private static UserNumber userNumber;

    public static void proceedGame() {
        showStartMessage();
        boolean restartValue = true;
        while(restartValue){
            setComputerNumber();
            playGame();
            restartValue = checkRestart();
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
    }

    private static boolean checkRestart() {
    }

    private static boolean checkSuccess() {
    }

    private static void showHint() {
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
