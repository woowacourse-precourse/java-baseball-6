package baseball.view;

import baseball.model.GameHint;

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
        final int strikeIndex = GameHint.STRIKE.getResultIndex();

        printStrikeHint(gameResult[strikeIndex]);
        printGameSuccess();
        printForInputRestartOrExit();
    }

    public void printGameFailResult(int[] gameResult) {
        final int noCount = 0;
        final int maxCount = 3;

        int strikeCount = gameResult[GameHint.STRIKE.getResultIndex()];
        int ballCount = gameResult[GameHint.BALL.getResultIndex()];
        int nothingCount = gameResult[GameHint.NOTHING.getResultIndex()];

        if (strikeCount > noCount && ballCount > noCount) {
            printStrikeAndBallHint(strikeCount, ballCount);
            return;
        }
        if (strikeCount > noCount && strikeCount < maxCount) {
            printStrikeHint(strikeCount);
        }
        if (ballCount > noCount) {
            printBallHint(ballCount);
        }
        if (nothingCount > noCount) {
            printNothingHint();
        }
    }

    private void printStrikeHint(int strikeCount) {
        System.out.println(strikeCount + GameHint.STRIKE.getMessage());
    }

    private void printStrikeAndBallHint(int strikeCount, int ballCount) {
        String space = " ";
        System.out.println(
                ballCount + GameHint.BALL.getMessage() + space +
                        strikeCount + GameHint.STRIKE.getMessage());
    }

    private void printBallHint(int ballCount) {
        System.out.println(ballCount + GameHint.BALL.getMessage());
    }

    private void printNothingHint() {
        System.out.println(GameHint.NOTHING.getMessage());
    }
}
