package baseball.view;

import baseball.domain.GameStatus;

public class OutputView {

    private static final String BALL_TEXT = "볼";
    private static final String STRIKE_TEXT = "스트라이크";
    private static final String NOTHING_TEXT = "낫싱";
    public static final String SPACE = " ";

    public OutputView() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void printGameEndMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public void printGameResult(GameStatus gameStatus) {
        StringBuilder result = new StringBuilder();

        appendBallCount(result, gameStatus);
        appendStrikeCount(result, gameStatus);
        appendNothingIfNecessary(result, gameStatus);

        System.out.println(result);
    }

    private void appendBallCount(StringBuilder result, GameStatus gameStatus) {
        if (gameStatus.isNotBallCntZero()) {
            result.append(gameStatus.getBallCnt())
                    .append(BALL_TEXT)
                    .append(SPACE);
        }
    }

    private void appendStrikeCount(StringBuilder result, GameStatus gameStatus) {
        if (gameStatus.isNotStrikeCntZero()) {
            result.append(gameStatus.getStrikeCnt())
                    .append(STRIKE_TEXT);
        }
    }

    private void appendNothingIfNecessary(StringBuilder result, GameStatus gameStatus) {
        if (gameStatus.isNothing()) {
            result.append(NOTHING_TEXT);
        }
    }

}
