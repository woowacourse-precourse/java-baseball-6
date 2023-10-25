package view;

import camp.nextstep.edu.missionutils.Console;

public class inputView {
    private static final String REQUIRE_PLAYER_BASEBALL_NUMBERS = "숫자를 입력해주세요 : ";
    private static final String CONTINUE_MESSANGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    // getRequirePlayerBaseballNumbers: 사용자로부터 숫자 세 개 입력
    public static String getRequirePlayerBaseballNumbers() {
        System.out.print(REQUIRE_PLAYER_BASEBALL_NUMBERS);
        return Console.readLine();
    }

    public static String askContinue() {
        System.out.println(CONTINUE_MESSANGE);
        return Console.readLine();
    }
}
