package baseball.view;

import baseball.config.GameConfig;

public class OutputView {

    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String END_MESSAGE = "%s개의 숫자를 모두 맞히셨습니다! 게임 종료%n";

    public static void printGameStartMessage() {
        System.out.println(START_MESSAGE);
    }

    public static void printGameEndMessage() {
        System.out.printf(END_MESSAGE, GameConfig.BASEBALL_LENGTH);
    }
}
