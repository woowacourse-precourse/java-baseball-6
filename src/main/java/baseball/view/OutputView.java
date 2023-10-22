package baseball.view;

import model.GameHint;

public class OutputView {

    public void printGameStart() {
        System.out.println(GameInstructions.GUIDE_GAME_START.getMessage());
    }

    public void printGameSuccess() {
        System.out.println(GameInstructions.GUIDE_GAME_SUCCESS.getMessage());
    }

    public void printForInputThreeDigitNumbers() {
        System.out.printf(GameInstructions.ASK_INPUT_THREE_DIGIT_NUMBERS.getMessage());
    }

    public void printForInputRestartOrExit() {
        System.out.println(GameInstructions.ASK_RESTART_OR_EXIT.getMessage());
    }

    public void printGameSuccessResult(int[] gameResult) {
        printStrikeHint(gameResult[0]);
        printGameSuccess();
        printForInputRestartOrExit();
    }

    public void printGameFailResult(int[] gameResult) {
        if (gameResult[0] > 0 && gameResult[0] < 3) {
            printStrikeHint(gameResult[0]);
            return;
        }
        if (gameResult[1] > 0) {
            printBallHint(gameResult[1]);
            return;
        }
        if (gameResult[2] > 0) {
            printNothingHint();
        }
    }

    private void printStrikeHint(int strikeCount) {
        System.out.println(strikeCount + GameHint.STRIKE.getMessage());
    }

    private void printBallHint(int ballCount) {
        System.out.println(ballCount + GameHint.BALL.getMessage());
    }

    private void printNothingHint() {
        System.out.println(GameHint.NOTHING.getMessage());
    }
}
