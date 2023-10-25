package baseball.console;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    private static final String inputMessage = "숫자를 입력해주세요 : ";
    private static final String restartMessage = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static String get() {
        System.out.print(inputMessage);
        String number = Console.readLine();
        return number;
    }

    public static String restart() {
        System.out.println(restartMessage);
        String number = Console.readLine();
        return number;
    }
}
