package baseball.view;

import baseball.constant.Constant;
import baseball.domain.BaseballGameResult;

public class OutputView {

    private static final String BASEBALL_GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String BASEBALL_GAME_CLEAR_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String BALL_MESSAGE = "볼 ";
    private static final String STRIKE_MESSAGE = "스트라이크";
    private static final String NOTHING_MESSAGE = "낫싱";
    private final BaseballGameResult gameResult;

    public OutputView(BaseballGameResult gameResult) {
        this.gameResult = gameResult;
    }

    public static void printStartMessage() {
        System.out.println(BASEBALL_GAME_START_MESSAGE);
    }

    public static void printClearMessage() {
        System.out.println(BASEBALL_GAME_CLEAR_MESSAGE);
    }

    public void printGameResult() {
        if (gameResult.ballCount == Constant.ZERO_NUMBER && gameResult.strikeCount != Constant.ZERO_NUMBER) {
            System.out.println(gameResult.strikeCount + STRIKE_MESSAGE);
        }
        if (gameResult.ballCount != Constant.ZERO_NUMBER && gameResult.strikeCount == Constant.ZERO_NUMBER) {
            System.out.println(gameResult.ballCount + BALL_MESSAGE);
        }
        if (gameResult.ballCount != Constant.ZERO_NUMBER && gameResult.strikeCount != Constant.ZERO_NUMBER) {
            System.out.println(gameResult.ballCount + BALL_MESSAGE + gameResult.strikeCount + STRIKE_MESSAGE);
        }
        if (gameResult.ballCount == Constant.ZERO_NUMBER && gameResult.strikeCount == Constant.ZERO_NUMBER) {
            System.out.println(NOTHING_MESSAGE);
        }
    }
}
