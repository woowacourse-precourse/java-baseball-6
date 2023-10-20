package baseball;

import java.util.HashSet;
import java.util.Set;

public class InputValidation {
    public void validateUserInput(String input) throws IllegalArgumentException{
        if (input.contains(" ")) {
            throw new IllegalArgumentException("공백 없이 오직 숫자만 입력해주시기 바랍니다.");
        }
        if (input.contains(",")) {
            throw new IllegalArgumentException("콤마 없이 오직 숫자만 입력해주시기 바랍니다.");
        }
        if (input.length() != 3) {
            throw new IllegalArgumentException("3개의 숫자만을 입력해주시기 바랍니다.");
        }
        validateInputNumber(input);
    }

    private void validateInputNumber(String input) {
        Set<Character> charSet = new HashSet<Character>();
        charSet.add(input.charAt(0));
        charSet.add(input.charAt(1));
        charSet.add(input.charAt(2));

        if (charSet.size() != 3) {
            throw new IllegalArgumentException("숫자를 중복하지 않고 입력해주시기 바랍니다.");
        }

        for (Character c : charSet) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException("숫자만을 입력해주시기 바랍니다.");
            }
            if (c.equals('0')) {
                throw new IllegalArgumentException("1 ~ 9 사이의 숫자만을 입력해주시기 바랍니다.");
            }
        }
    }
}
