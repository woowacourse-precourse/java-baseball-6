package baseball.view;

import baseball.domain.GameResult;

public class OutputView {

    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String GAMEOVER_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String BALL_MESSAGE = "볼 ";
    private static final String STRIKE_MESSAGE = "스트라이크";
    private static final String NOTHING_MESSAGE = "낫싱";
    private static OutputView instance;

    public static OutputView getInstance() {
        if (instance == null) {
            instance = new OutputView();
        }
        return instance;
    }

    public void printStart() {
        System.out.println(START_MESSAGE);
    }

    public void printResult(GameResult gameResult) {
        StringBuilder result = new StringBuilder();
        if (gameResult.hasBall()) {
            result.append(gameResult.getBallCount());
            result.append(BALL_MESSAGE);
        }
        if (gameResult.hasStrike()) {
            result.append(gameResult.getStrikeCount());
            result.append(STRIKE_MESSAGE);
        }
        if (gameResult.isNothing()) {
            result.append(NOTHING_MESSAGE);
        }
        System.out.println(result);
    }

    public void printGameOver() {
        System.out.println(GAMEOVER_MESSAGE);
    }
}
