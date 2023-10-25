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
        result.append(getMessageOf(TryResult.BALL, gameResult));
        result.append(insertSpace(gameResult));
        result.append(getMessageOf(TryResult.STRIKE, gameResult));
        result.append(getNothingMessage(gameResult));
        System.out.println(result);
    }

    private String getMessageOf(TryResult tryResult, GameResult gameResult) {
        if (gameResult.hasResult(tryResult)) {
            return gameResult.getCount(tryResult) + tryResult.getMessage();
        }
        return BLANK;
    }

    private String insertSpace(GameResult gameResult) {
        if (gameResult.hasResult(TryResult.BALL) && gameResult.hasResult(TryResult.STRIKE)) {
            return " ";
        }
        return BLANK;
    }

    private String getNothingMessage(GameResult gameResult) {
        if (gameResult.isNothing()) {
            return TryResult.NOTHING.getMessage();
        }
        return BLANK;
    }

    public void printGameOver() {
        System.out.println(GAMEOVER_MESSAGE);
    }
}
