package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String SUGGESTED_NUMBER_PROMPT = "숫자를 입력해주세요 : ";
    private static final String GAME_CONTINUE_CHOICE_PROMPT = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static String getSuggestedNumber() {
        System.out.println(SUGGESTED_NUMBER_PROMPT);
        return Console.readLine();
    }

    public static String getGameContinueChoice() {
        System.out.println(GAME_CONTINUE_CHOICE_PROMPT);
        return Console.readLine();
    }
}
