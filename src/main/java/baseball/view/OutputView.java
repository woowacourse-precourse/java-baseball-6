package baseball.view;

import static baseball.domain.BallStatus.BALL;
import static baseball.domain.BallStatus.NOTHING;
import static baseball.domain.BallStatus.STRIKE;
import static baseball.util.Constants.SPACE;

import baseball.domain.PlayResult;

public class OutputView {
    private static final OutputView instance = new OutputView();

    private OutputView() {
    }

    public static OutputView getInstance() {
        return instance;
    }

    public void printMainMessage() {
        System.out.println(Message.OUTPUT_MAIN_MESSAGE.message);
    }

    public void printResult(PlayResult result) {
        System.out.println(getBallAndStrike(result));

    }

    private String getBallAndStrike(PlayResult result) {
        return getResultMessage(result.getBall(), result.getStrike());
    }

    private String getResultMessage(int ball, int strike) {
        StringBuilder gameResult = new StringBuilder();
        if (ball == 0 && strike == 0) {
            return NOTHING.getMessage();
        }

        appendBallResult(gameResult, ball);
        appendStrikeResult(gameResult, strike);

        return gameResult.toString();
    }

    private void appendBallResult(StringBuilder gameResult, int ball) {
        if (ball != 0) {
            gameResult.append(ball).append(BALL.getMessage());
        }
        if (gameResult.length() != 0) {
            gameResult.append(SPACE);
        }
    }

    private void appendStrikeResult(StringBuilder gameResult, int strike) {
        if (strike != 0) {
            gameResult.append(strike).append(STRIKE.getMessage());
        }
    }

    public void printGameEnd() {
        System.out.println(Message.OUTPUT_GAME_END.message);
    }

    private enum Message {
        OUTPUT_MAIN_MESSAGE("숫자 야구 게임을 시작합니다."),
        OUTPUT_GAME_END("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

        private final String message;

        Message(String message) {
            this.message = message;
        }
    }
}
