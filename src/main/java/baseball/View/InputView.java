package baseball.View;

import baseball.Util.Validator;
import camp.nextstep.edu.missionutils.Console;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputView {
    public static final String REQUEST_INPUT_MESSAGE  = "숫자를 입력해주세요 : ";

    public static String requestInputNumbers() {
        System.out.print(REQUEST_INPUT_MESSAGE);
        String input = Console.readLine();
        validateInput(input);
        return input;
    }

    public static void validateInput(String input) {
        Validator.isNullOrEmpty(input);
        input = input.trim();
        Validator.isThreeDigitNumber(input);
        Validator.isUniqueNumber(input);
    }


    public static String requestRestartOrExit() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        validateRestartOrEnd(input);
        return input;
    }

    private static void validateRestartOrEnd(String input) {
        Validator.isNullOrEmpty(input);
        Validator.isOneOrTwo(input);
    }
}
