package baseball.view;

import static baseball.domain.TryResult.BALL;
import static baseball.domain.TryResult.NOTHING;
import static baseball.domain.TryResult.STRIKE;

import baseball.domain.BaseballGame;
import baseball.domain.GameResult;
import baseball.domain.TryResult;

public class OutputView {

    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String GAMEOVER_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String BLANK = "";
    private static final String SPACE = " ";
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
        if (!gameResult.contains(BALL)) {
            return BLANK;
        }
        String message = gameResult.getCount(BALL) + BALL.getMessage();
        if (gameResult.containsStrike()) {
            message += SPACE;
        }
        return message;
    }

    private String getStrikeMessage(GameResult gameResult) {
        if (!gameResult.contains(STRIKE)) {
            return BLANK;
        }
        return gameResult.getCount(STRIKE) + STRIKE.getMessage();
    }

    private String getNothingMessage(GameResult gameResult) {
        if (gameResult.hasResult()) {
            return BLANK;
        }
        return NOTHING.getMessage();
    }

    public void printGameOver() {
        System.out.println(GAMEOVER_MESSAGE);
    }
}
