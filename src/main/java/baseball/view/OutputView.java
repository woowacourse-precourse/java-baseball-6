package baseball.view;

import static baseball.domain.util.RandomBallGenerator.SIZE_OF_NUMBER;

public class OutputView {

    private static final String STARTING_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String ENDING_MESSAGE = SIZE_OF_NUMBER + "개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public static void printStartMessage() {
        System.out.println(STARTING_MESSAGE);
    }

    public static void printGameResult(String gameResult) {
        System.out.println(gameResult);
    }

    public static void printEndMessage() {
        System.out.println(ENDING_MESSAGE);
    }
}
