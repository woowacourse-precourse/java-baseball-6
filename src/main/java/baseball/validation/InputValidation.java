package baseball.validation;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 입력값에 대한 검증을 진행하는 클래스
 */
public class InputValidation {

    /**
     * 사용자의 숫자 입력값이 자연수로만 이루어져 있는지 검증한다.
     */
    public void validateNaturalNumber(String input) {
        Pattern pattern = Pattern.compile("^[0-9]+$");
        Matcher matcher = pattern.matcher(input);

        if (!matcher.matches()) {
            throw new IllegalArgumentException("입력된 문자열은 자연수로만 이루어져야 합니다.");
        }
    }

    public void isLengthAtLeastFour(String input) {
        if (input.length() >= 4) {
            throw new IllegalArgumentException("입력값은 3 이하여야 합니다.");
        }
    }

    public void validateUniqueIntegers(String input) {
        String[] integers = input.split("");
        int integerCount = integers.length;
        long distinctIntegerCount = Arrays.stream(integers)
                .mapToInt(Integer::parseInt)
                .distinct()
                .count();

        if (distinctIntegerCount != integerCount) {
            throw new IllegalArgumentException("입력값은 서로 다른 정수여야 합니다.");
        }
    }
}