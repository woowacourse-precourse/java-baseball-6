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

    public void printGameResult(int[] gameResult) {
        if (gameResult[0] == 3) {
            System.out.println(gameResult[0] + GameHint.STRIKE.getMessage());
            printGameSuccess();
        }
        if (gameResult[0] > 0 && gameResult[0] < 3) {
            System.out.println(gameResult[0] + GameHint.STRIKE.getMessage());
        }
        if (gameResult[1] > 0) {
            System.out.println(gameResult[1] + GameHint.BALL.getMessage());
        }
        if (gameResult[2] > 0) {
            System.out.println(GameHint.NOTHING.getMessage());
        }
    }
}
