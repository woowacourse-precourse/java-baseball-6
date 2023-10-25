package baseball.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class InputView {

    public static String inputUniqueDigit() {
        String input = Console.readLine();
        validateUniqueDigit(input);
        return input;
    }

    public static String inputExitOption() {
        String input = Console.readLine();
        validateExitOption(input);
        return input;
    }

    public static void validateUniqueDigit(String input) {
        validateDigit(input);
        validateUnique(input);
    }

    private static void validateDigit(String input) throws IllegalArgumentException {
        boolean isThreeDigit = input.matches("[1-9][1-9][1-9]");
        if (!isThreeDigit) {
            throw new IllegalArgumentException("1부터 9사이의 세 자리 숫자로 입력해야 합니다.");
        }
    }

    private static void validateUnique(String input) throws IllegalArgumentException {
        Set<String> numberSet = new HashSet<>(Arrays.asList(input.split("")));

        boolean isUniqueDigit = numberSet.size() == 3;
        if (!isUniqueDigit) {
            throw new IllegalArgumentException("서로 다른 세 자리 숫자로 입력해야 합니다.");
        }
    }

    private static void validateExitOption(String input) {
        if (!(input.equals("1") || input.equals("2"))) {
            throw new IllegalArgumentException("1번을 눌러 재시작하거나 2번을 눌러 종료하십시오.");
        }
    }
}
