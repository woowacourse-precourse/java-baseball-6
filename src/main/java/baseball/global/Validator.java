package baseball.global;

import static baseball.global.constant.BaseballGameConstant.*;

import baseball.global.constant.BaseballGameConstant;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {

    public static void validateRestart(String input) {
        if (!input.equals(IS_RESTART) && !input.equals(IS_STOP)) {
            throw new IllegalArgumentException("재시작 옵션 입력을 잘못하였습니다.");
        }
    }

    public static void validatePlayerInput(String[] input) {
        validateInputLength(input);
        validateDuplicatedInput(input);
        validateNumbersFormat(input);
    }

    public static void validateInputLength(String[] input) {
        if (input.length != PLAY_COUNT) {
            throw new IllegalArgumentException("숫자 입력 길이가 정확히 세자리가 아닙니다.");
        }
    }

    public static void validateDuplicatedInput(String[] input) {
        HashSet<String> set = new HashSet<>(List.of(input));
        if (set.size() != input.length) {
            throw new IllegalArgumentException("숫자 입력 중 중복된 값이 있습니다.");
        }
    }

    public static void validateNumbersFormat(String[] numbers) {
        for (String number : numbers) {
            validateNumberFormat(number);
        }
    }

    public static void validateNumberFormat(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
