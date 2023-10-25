package view;

import camp.nextstep.edu.missionutils.Console;

public class inputView {
    private static final String REQUIRE_PLAYER_BASEBALL_NUMBERS = "숫자를 입력해주세요 : ";

    // getRequirePlayerBaseballNumbers: 사용자로부터 숫자 세 개 입력
    public static String getRequirePlayerBaseballNumbers() {
        System.out.print(REQUIRE_PLAYER_BASEBALL_NUMBERS);
        return Console.readLine();
    }
}
