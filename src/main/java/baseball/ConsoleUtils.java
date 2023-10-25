package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;

public class ConsoleUtils {
    public static String readLine() {
        return Console.readLine();
    }

    public static String inputRestartOrExit() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = readLine();
        if (!isRightAnswer(input)) {
            throw new IllegalArgumentException();
        }
        return input;
    }

    public static boolean isRightAnswer(String input) {
        return Pattern.matches("[1-2]", input);
    }
}
