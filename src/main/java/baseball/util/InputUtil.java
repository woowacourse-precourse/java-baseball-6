package baseball.util;

import camp.nextstep.edu.missionutils.Console;

public class InputUtil {

    /**
     * 사용자 입력 받기
     * @return 문자열 입력값
     */
    public static String getUserInput(String message) {
        System.out.print(message);
        return Console.readLine();
    }
}
