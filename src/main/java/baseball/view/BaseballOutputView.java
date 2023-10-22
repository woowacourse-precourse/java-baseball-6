package baseball.view;

import baseball.domain.Score;

public class BaseballOutputView implements OutputView {

    private static final String START_BASEBALL_GAME_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String END_BASEBALL_GAME_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String NOTHING_MESSAGE = "낫싱";
    private static final String STRIKE_MESSAGE = "스트라이크";
    private static final String BALL_MESSAGE = "볼";
    private static final String SPACE = " ";
    private static final int ZERO_COUNT = 0;

    public void startGame() {
        System.out.println(START_BASEBALL_GAME_MESSAGE);
    }

    public void endGame() {
        System.out.println(END_BASEBALL_GAME_MESSAGE);
    }

    public void matchResult(Score score) {
        String result = formatScore(score);
        System.out.println(result);
    }

    private String formatScore(Score score) {
        int ballCount = score.getBallCount();
        int strikeCount = score.getStrikeCount();
        if (ballCount == ZERO_COUNT && strikeCount == ZERO_COUNT) {
            return NOTHING_MESSAGE;
        }
        if (ballCount == ZERO_COUNT) {
            return strikeCount + STRIKE_MESSAGE;
        }
        if (strikeCount == ZERO_COUNT) {
            return ballCount + BALL_MESSAGE;
        }
        return ballCount + BALL_MESSAGE + SPACE + strikeCount + STRIKE_MESSAGE;
    }
}
