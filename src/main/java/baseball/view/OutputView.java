package baseball.view;

import baseball.domain.GameResult;

import baseball.constant.*;

public class OutputView {

    private static final String SPACE = " ";
    private static final String STRIKE = "스트라이크";
    private static final String BALL = "볼";
    private static final String NOTHING = "낫싱";

    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";

    private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String END_GAME_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String RESTART_GAME_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private static final StringBuilder stringbuilder = new StringBuilder();

    public static void printGameStartMessage() {
        System.out.println(GAME_START_MESSAGE);
    }

    public static void printInputMessage() {
        System.out.print(INPUT_MESSAGE);
    }

    public static void printGameEndMessage() {
        System.out.println(END_GAME_MESSAGE);
        System.out.println(RESTART_GAME_MESSAGE);
    }

    public static void printPlayerResultMessage(GameResult gameResult) {
        generateResultMessage(gameResult);
        System.out.println(stringbuilder);
    }

    private static void generateResultMessage(GameResult gameResult) {
        initStringBuilder();
        checkBall(gameResult);
        checkStrike(gameResult);
        checkNothing(gameResult);
    }

    private static void checkStrike(GameResult gameResult) {
        if (gameResult.getStrike() > 0) {
            stringbuilder.append(gameResult.getStrike()).append(STRIKE);
        }
    }

    private static void checkBall(GameResult gameResult) {
        if (gameResult.getBall() > 0) {
            stringbuilder.append(gameResult.getBall()).append(BALL).append(SPACE);
        }
    }

    private static void checkNothing(GameResult gameResult) {
        if (gameResult.getStrike() == 0 && gameResult.getBall() == 0) {
            stringbuilder.append(NOTHING);
        }
    }

    private static void initStringBuilder() {
        stringbuilder.setLength(0);
    }


}
