package baseball;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class Validator {

    private static final Validator instance = new Validator();

    private Validator() {
    }

    public static Validator getInstance() {
        return instance;
    }

    public static void validateInput(final String input) {
        validateInputDigit(input);
        validateInputRange(input);
        validateInputContainsZero(input);
        validateDuplicateNumber(input);
    }

    private static void validateInputRange(final String input) {
        if (input.length() == Const.NUMBER_LENGTH) return;
        throw new IllegalArgumentException("세개의 숫자만 입력받을 수 있습니다.");
    }

    private static void validateInputDigit(final String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("1~9 이외의 문자가 입력되었습니다.");
        }
    }

    private static void validateInputContainsZero(final String input) {
        String[] split = input.split("");
        if (Arrays.asList(split).contains("0")) {
            throw new IllegalArgumentException("입력에 0이 포함되었습니다.");
        }
    }

    private static void validateDuplicateNumber(final String input) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < input.length(); i++) {
            if (set.contains(input.charAt(i))) {
                throw new IllegalArgumentException("중복된 숫자가 입력되었습니다.");
            }
            set.add(input.charAt(i));
        }
    }

    public static void validateCommand(int command) {
        if (command != 1 && command != 2) {
            throw new IllegalArgumentException("게임 완료 명령은 1, 2만 입력될 수 있습니다.");
        }
    }
}
