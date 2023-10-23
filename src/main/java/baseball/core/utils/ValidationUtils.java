package baseball.core.utils;

import java.util.Arrays;

import static baseball.core.code.ErrorMessage.*;
import static baseball.core.code.ErrorMessage.INPUT_NOT_DUPLICATED;

/**
 * ValidationUtils
 * <pre>
 * Describe here
 * </pre>
 *
 * @version 1.0,
 */
public class ValidationUtils {

    private ValidationUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static final int STANDARD_NUMBER = 3;

    /**
     * 사용자 입력 값 유효성 체크
     * @param input
     */
    public static void validInput(String input) {
        // 입력 값 유효성 체크
        if (input.isBlank()) {
            throw new IllegalArgumentException(INPUT_NOT_BLANK.getDescription());
        }

        try {
            Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException(INPUT_NOT_NUMBER.getDescription());
        }

        if (input.length() != STANDARD_NUMBER) {
            throw new IllegalArgumentException(INPUT_ONLY_3.getDescription());
        }

        long distinctRemoveStringCount = Arrays.asList(input.split("")).stream().distinct().count();
        if (distinctRemoveStringCount != input.length()) {
            throw new IllegalArgumentException(INPUT_NOT_DUPLICATED.getDescription());
        }
    }
}
