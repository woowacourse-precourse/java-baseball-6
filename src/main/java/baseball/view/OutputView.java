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
        result.append(getBallMessage(gameResult));
        result.append(getStrikeMessage(gameResult));
        result.append(getNothingMessage(gameResult));
        System.out.println(result);
    }

    private String getBallMessage(GameResult gameResult) {
        if (gameResult.hasBall()) {
            return gameResult.getBallCount() + BALL_MESSAGE;
        }
        return "";
    }

    private String getStrikeMessage(GameResult gameResult) {
        if (gameResult.hasStrike()) {
            return gameResult.getStrikeCount() + STRIKE_MESSAGE;
        }
        return "";
    }

    private String getNothingMessage(GameResult gameResult) {
        if (gameResult.isNothing()) {
            return NOTHING_MESSAGE;
        }
        return "";
    }

    public void printGameOver() {
        System.out.println(GAMEOVER_MESSAGE);
    }
}
