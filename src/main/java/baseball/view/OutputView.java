package baseball.view;

import baseball.constant.Constant;

public class OutputView {

    /**
     * 숫자야구게임의 시작과 끝에 출력되는 메시지와 관련된 문자열 및 메서드
     */
    private static final String START_MESSAGE = "숫자야구게임을 시작합니다.";
    private static final String END_MESSAGE = Constant.GAME_NUMBERS_SIZE + "개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public static void printStartMessage() {
        System.out.println(START_MESSAGE);
    }

    public static void printEndMessage() {
        System.out.println(END_MESSAGE);
    }

}
