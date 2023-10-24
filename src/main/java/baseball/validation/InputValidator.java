package baseball.validation;

import baseball.constant.Message;
import baseball.constant.Number;

/**
 * 입력값에 대한 검증 메소드를 가지는 클래스
 */
public class InputValidator {

    public static void validateInputNum(String input) {
        validateLength(input);
        validateDomain(input);
        validateDuplicate(input);
    }

    private static void validateLength(String input) {
        if (input.length() != Number.GAME_LENGTH) {
            throw new IllegalArgumentException(Message.INPUT_LENGTH_EXCEPTION_MSG);
        }
    }

    private static void validateDomain(String input) {
        if (!input.chars().map(Character::getNumericValue)
                .allMatch(num -> Number.RANGE_START <= num && num <= Number.RANGE_END)) {
            throw new IllegalArgumentException(Message.INPUT_DOMAIN_EXCEPTION_MSG);
        }
    }

    private static void validateDuplicate(String input) {
        if (input.chars().distinct().count() != input.length()) {
            throw new IllegalArgumentException(Message.INPUT_DUPLICATED_EXCEPTION_MSG);
        }
    }

    public static void validateRestartNum(String input) {
        if (!input.matches("\\d") ||
                (Integer.parseInt(input) != Number.RESTART_NUM &&
                        Integer.parseInt(input) != Number.FINISH_NUM)) {
            throw new IllegalArgumentException(Message.INPUT_DOMAIN_EXCEPTION_MSG);
        }
    }

}
