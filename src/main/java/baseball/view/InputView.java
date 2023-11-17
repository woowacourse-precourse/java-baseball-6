package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String ASK_USER_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String ASK_PLAY_AGAIN_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static String readUserNumber() {
        System.out.print(ASK_USER_NUMBER_MESSAGE);
        return Console.readLine();
    }

    public static String readPlayAgainInput() {
        System.out.println(ASK_PLAY_AGAIN_MESSAGE);
        return Console.readLine();
    }
}
