package baseball.view;

import baseball.util.GameConstants;

public class OutputView {
    private final String GUESS_SUCCESS_MESSAGE = GameConstants.DIGIT_SIZE + "개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private final String STRIKE_MESSAGE = "스트라이크";
    private final String BALL_MESSAGE = "볼";
    private final String NOTTING_MESSAGE = "낫싱";

    public void printGameResult(int strikeCount, int ballCount) {
        if (strikeCount == 0 && ballCount == 0) {
            System.out.println(NOTTING_MESSAGE);

            return;
        }

        String resultMessage = ballCount + BALL_MESSAGE + " " + strikeCount + STRIKE_MESSAGE;

        if (ballCount == 0) {
            resultMessage = strikeCount + STRIKE_MESSAGE;
        }

        if (strikeCount == 0) {
            resultMessage = ballCount + BALL_MESSAGE;
        }

        System.out.println(resultMessage);
    }

    public void printSuccessMessage() {
        System.out.println(GUESS_SUCCESS_MESSAGE);
    }
}
