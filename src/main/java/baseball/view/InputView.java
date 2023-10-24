package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String ASK_SUGGESTED_NUMBER = "숫자를 입력해주세요 : ";
    private static final String ASK_GAME_CONTINUE_CHOICE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static String getSuggestedNumber() {
        System.out.println(ASK_SUGGESTED_NUMBER);
        return Console.readLine();
    }

    public static String getGameContinueChoice() {
        System.out.println(ASK_GAME_CONTINUE_CHOICE);
        return Console.readLine();
    }
}
