package baseball;

import static baseball.MessageConstant.CONTROL_SIGN_LENGTH_EXCEPTION_MSG;
import static baseball.MessageConstant.CONTROL_SIGN_NUMBER_EXCEPTION_MSG;
import static baseball.MessageConstant.INPUT_CONTAIN_ZERO_EXCEPTION_MSG;
import static baseball.MessageConstant.INPUT_DUPLICATION_EXCEPTION_MSG;
import static baseball.MessageConstant.INPUT_LENGTH_EXCEPTION_MSG;
import static baseball.MessageConstant.INPUT_NOT_ONLY_DIGIT_EXCEPTION_MSG;

import java.util.List;
import java.util.stream.Collectors;

public class InputValidation {

    public List<Integer> validateUserNumbers(String input) {
        String trimmed = deleteSpace(input);

        validateLength(trimmed);
        validateOnlyDigit(trimmed);
        validateContainZero(trimmed);
        validateDuplicateNumber(trimmed);

        return (convertStrToIntegerList(trimmed));
    }

    public void validateRestartOrStop(String input) {
        String trimmed = deleteSpace(input);

        validateSignLength(trimmed);
        validateSign(trimmed);
    }

    // 길이에 대한 검증
    private void validateLength(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException(INPUT_LENGTH_EXCEPTION_MSG);
        }
    }

    private String deleteSpace(String input) {
        return input.replace(" ", "");
    }

    // 숫자로만 이루어져있는지 검증
    private void validateOnlyDigit(String input) {
        boolean checkOnlyDigit = input.chars().allMatch(Character::isDigit);

        if (!checkOnlyDigit) {
            throw new IllegalArgumentException(INPUT_NOT_ONLY_DIGIT_EXCEPTION_MSG);
        }
    }

    // 0을 포함했는지 검증
    private void validateContainZero(String input) {
        if (input.contains("0")) {
            throw new IllegalArgumentException(INPUT_CONTAIN_ZERO_EXCEPTION_MSG);
        }
    }

    // 중복수에 대한 검증
    private void validateDuplicateNumber(String input) {
        if (input.chars().distinct().count() < 3) {
            throw new IllegalArgumentException(INPUT_DUPLICATION_EXCEPTION_MSG);
        }
    }

    // 문자열 -> 리스트 변환
    private List<Integer> convertStrToIntegerList(String input) {
        return input.chars()
                .mapToObj(Character::getNumericValue)
                .collect(Collectors.toList());
    }

    private void validateSign(String input) {
        if (input.charAt(0) != '1' && input.charAt(0) != '2') {
            throw new IllegalArgumentException(CONTROL_SIGN_NUMBER_EXCEPTION_MSG);
        }
    }

    private void validateSignLength(String input) {
        if (input.length() != 1) {
            throw new IllegalArgumentException(CONTROL_SIGN_LENGTH_EXCEPTION_MSG);
        }
    }
}
