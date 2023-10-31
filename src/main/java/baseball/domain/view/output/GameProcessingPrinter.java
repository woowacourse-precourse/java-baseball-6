package baseball.domain.view.output;

import baseball.domain.config.GameConfig;

public class GameProcessingPrinter {
    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String NOTHING = "낫싱";
    private static final String STRIKE = "스트라이크";
    private static final String BALL = "볼";
    private static final String END_MESSAGE = "%d개의 숫자를 모두 맞히셨습니다! 게임 종료\n";

    public static void printGameStart() {
        System.out.println(START_MESSAGE);
    }

    public static void printGameEnd() {
        System.out.printf(END_MESSAGE, GameConfig.BASEBALL_SIZE);
    }

    public static void printAllStrike() {
        System.out.println(GameConfig.BASEBALL_SIZE + STRIKE);
    }

    public static void printNothing() {
        System.out.println(NOTHING);
    }

    public static void printProceeding(int ball, int strike) {
        if (ball > 0) {
            System.out.print(ball + BALL + " ");
        }
        if (strike > 0) {
            System.out.print(strike + STRIKE);
        }
        System.out.println();
    }
}
