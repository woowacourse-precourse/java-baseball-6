package baseball.view;

import baseball.config.GameConfig;
import baseball.domain.GameResult;

public class OutputView {

    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String STRIKE = "스트라이크";
    private static final String BALL = "볼";
    private static final String NOTHING = "낫싱";
    private static final String END_MESSAGE = "%s개의 숫자를 모두 맞히셨습니다! 게임 종료%n";

    public static void printGameStartMessage() {
        System.out.println(START_MESSAGE);
    }

    public static void printGameResult(GameResult gameResult) {
        if (gameResult.isAllStrike()) {
            System.out.println(gameResult.getStrikeCount() + STRIKE);
            return;
        }

        if (gameResult.isNothing()) {
            System.out.println(NOTHING);
            return;
        }

        System.out.println(gameResult.getBallCount() + BALL + " " + gameResult.getStrikeCount() + STRIKE);
    }

    public static void printGameEndMessage() {
        System.out.printf(END_MESSAGE, GameConfig.BASEBALL_LENGTH);
    }
}
