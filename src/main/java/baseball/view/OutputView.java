package baseball.view;

import baseball.domain.GameResult;
import baseball.domain.TryResult;

public class OutputView {

    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String GAMEOVER_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String BLANK = "";
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
        result.append(insertSpace(gameResult));
        result.append(getStrikeMessage(gameResult));
        result.append(getNothingMessage(gameResult));
        System.out.println(result);
    }

    private String insertSpace(GameResult gameResult) {
        if (gameResult.hasBall() && gameResult.hasStrike()) {
            return " ";
        }
        return BLANK;
    }

    private String getBallMessage(GameResult gameResult) {
        if (gameResult.hasBall()) {
            return gameResult.getBallCount() + TryResult.BALL.getResultName();
        }
        return BLANK;
    }

    private String getStrikeMessage(GameResult gameResult) {
        if (gameResult.hasStrike()) {
            return gameResult.getStrikeCount() + TryResult.STRIKE.getResultName();
        }
        return BLANK;
    }

    private String getNothingMessage(GameResult gameResult) {
        if (gameResult.isNothing()) {
            return TryResult.NOTHING.getResultName();
        }
        return BLANK;
    }

    public void printGameOver() {
        System.out.println(GAMEOVER_MESSAGE);
    }
}
