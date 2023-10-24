package baseball.view;

import baseball.constant.GameConstants;

public class Message {

    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String END_MESSAGE = GameConstants.BALL_COUNT + "개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String RETRY_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";

    public static void printGameStartMessage() {
        System.out.println(START_MESSAGE);
    }

    public static void printGameEndMessage() {
        System.out.println(END_MESSAGE);
    }

    public static void printGameRetryMessage() {
        System.out.println(RETRY_MESSAGE);
    }

    public static void printPlayerInputNumberMessage() {
        System.out.print(INPUT_MESSAGE);
    }
}
