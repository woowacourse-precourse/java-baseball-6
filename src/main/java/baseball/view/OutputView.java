package baseball.view;

import baseball.dto.GameResult;

public class OutputView {
    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String STRIKE = "스트라이크";
    private static final String BALL = "볼";
    private static final String NOTHING = "낫싱";
    private static final String EMPTY = " ";
    private static final String CLEAR_MESSAGE = "3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public static void start() {
        System.out.println(START_MESSAGE);
    }

    public static void result(GameResult gameResult) {
        System.out.println(createResultMessage(gameResult));
    }

    private static String createResultMessage(GameResult gameResult) {
        if (gameResult.isNothing()) {
            return NOTHING;
        }
        if (gameResult.isClear()) {
            return CLEAR_MESSAGE;
        }
        if (gameResult.isStrikeOnly()) {
            return gameResult.strike() + STRIKE;
        }
        if (gameResult.isBallOnly()) {
            return gameResult.ball() + BALL;
        }
        return gameResult.ball() + BALL + EMPTY + gameResult.strike() + STRIKE;
    }
}
