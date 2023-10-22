package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String MSG_START = "숫자 야구 게임을 시작합니다.";
    private static final String MSG_REQUESTING_INPUT = "숫자를 입력해주세요.";
    private static final String MSG_GAME_OVER = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String MSG_ASK_IF_CONTINUES = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public static final String MSG_EXCEPTION_INVALID_INPUT = "올바르지 않은 입력값입니다.";
    public static final String EXIT = "2";

    public static void printStart() {
        System.out.println(MSG_START);
    }

    public static void printRequestingInput() {
        System.out.println(MSG_REQUESTING_INPUT);
    }

    public static void printGameOver() {
        System.out.println(MSG_GAME_OVER);
        System.out.println(MSG_ASK_IF_CONTINUES);
    }

    public static String getUserInput() { return Console.readLine(); }

}
