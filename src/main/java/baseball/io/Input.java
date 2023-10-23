package baseball.io;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    public static String consoleLine() {
        return Console.readLine();
    }

    // TODO : 특정 타입의 인풋 메서드를 지원해보자
    public static Integer consoleNumber() {
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 입력값입니다", e);
        }
    }

}
