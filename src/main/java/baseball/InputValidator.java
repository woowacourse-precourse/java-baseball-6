package baseball;

import java.util.HashSet;
import java.util.Set;

public class InputValidator {
    public static void validateInput(String input) throws IllegalArgumentException {
        isNull(input);
        isLengthThree(input);
        isDuplicateNumber(input);
    }

    public static void restartEndValidateInput(String input) throws IllegalArgumentException {
        isNull(input);
        containOneOrTwo(input);
    }

    public static void isNull(String input) throws IllegalArgumentException {
        if (input == null) {
            throw new IllegalArgumentException("입력값이 null입니다");
        }
    }

    public static void isLengthThree(String input) throws IllegalArgumentException {
        if (input.length()!=3) {
            throw new IllegalArgumentException("3자리의 수를 입력해 주세요");
        }
    }

    public static void isDuplicateNumber(String input) throws IllegalArgumentException {

        Set<Character> set = new HashSet<>();
        for (int i=0;i<input.length();i++) {
            char character = input.charAt(i);
            set.add(character);
        }
        if (set.size()!=3) {
            throw new IllegalArgumentException("1부터 9까지 서로 다른 수를 입력해 주세요");
        }
    }

    public static void containOneOrTwo(String input) throws IllegalArgumentException {
        if (!("1".equals(input) || "2".equals(input))) {
            throw new IllegalArgumentException("입력값은 1 또는 2여야 합니다.");
        }
    }
}