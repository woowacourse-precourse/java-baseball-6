package baseball.validation;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static baseball.constant.MessageConst.*;
import static baseball.constant.NumberConst.*;

/**
 * 입력값에 대한 검증을 진행하는 클래스
 */
public class InputValidation {

    /**
     * 사용자의 입력값에 대한 모든 검증을 진행한다.
     */
    public void validateInputNum(String input) {
        validateNull(input);
        validateLengthAtLeastFour(input);
        validateNaturalNumber(input);
        validateUniqueIntegers(input);
    }

    /**
     * 사용자의 숫자 입력값이 자연수로만 이루어져 있는지 검증한다.
     */
    public void validateNaturalNumber(String input) {
        Pattern pattern = Pattern.compile("^[" + START_NUM + "-" + END_NUM + "]+$");
        Matcher matcher = pattern.matcher(input);

        if (!matcher.matches()) {
            throw new IllegalArgumentException(INPUT_RANGE_NATURAL_EXCEPTION_MSG);
        }
    }

    public void validateLengthAtLeastFour(String input) {
        if (input.length() >= 4) {
            throw new IllegalArgumentException(INPUT_LENGTH_EXCEPTION_MSG);
        }
    }

    public void validateUniqueIntegers(String input) {
        String[] integers = input.split("");
        long distinctIntegerCount = Arrays.stream(integers)
                .mapToInt(Integer::parseInt)
                .distinct()
                .count();

        if (distinctIntegerCount != INPUT_LENGTH) {
            throw new IllegalArgumentException(INPUT_DUPLICATE_EXCEPTION_MSG);
        }
    }

    /**
     * 재입력된 값이 1 또는 2인지 검증한다.
     */
    public void validateOneOrTwo(int input) {
        if (input != RESTART_NUM && input != EXIT_NUM) {
            throw new IllegalArgumentException(INPUT_RESTART_EXIT_EXCEPTION_MSG);
        }
    }

    /**
     * 입력된 값이 null인지 검증한다.
     */
    public void validateNull(String input) {
        if (input == null) {
            throw new IllegalArgumentException(INPUT_RANGE_NATURAL_EXCEPTION_MSG);
        }
    }
}