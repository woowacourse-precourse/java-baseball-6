package baseball.view;

import baseball.constants.Constants;

public class OutputView {

    public static void startGame() {
        System.out.println(Constants.NUMBER_BASKETBALL_GAME_START);
    }

    public static void showGameResult(int[] strikeAndBallCount) {

        int strikeCount = strikeAndBallCount[Constants.STRIKE_INDEX];
        int ballCount = strikeAndBallCount[Constants.BALL_INDEX];

        if (strikeCount == 0 && ballCount == 0) {
            System.out.println(Constants.NOTHING);
        } else if (strikeCount == 0 && ballCount > 0) {
            System.out.println(ballCount + Constants.BALL);
        } else if (strikeCount > 0 && ballCount == 0) {
            System.out.println(strikeCount + Constants.STRIKE);
        } else if (strikeCount > 0 && ballCount > 0) {
            System.out.println(
                ballCount + Constants.BALL + Constants.BLANK + strikeCount + Constants.STRIKE);
        }
    }

    public static void finishGame() {
        System.out.println(Constants.SUCCESS_AND_GAME_FINISH);
    }

}
