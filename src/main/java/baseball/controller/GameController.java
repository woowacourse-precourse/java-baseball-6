package baseball.controller;

public class GameController {

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
    }

    private static void setComputerNumber() {
    }

    private static void showStartMessage() {
    }
}
