package baseball;

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
            throw new IllegalArgumentException("3개의 숫자만 입력해주세요.");
        }
    }

    private String deleteSpace(String input) {
        return input.replace(" ", "");
    }

    // 숫자로만 이루어져있는지 검증
    private void validateOnlyDigit(String input) {
        boolean checkOnlyDigit = input.chars().allMatch(Character::isDigit);

        if (!checkOnlyDigit) {
            throw new IllegalArgumentException("숫자만 입력해 주세요.");
        }
    }

    // 0을 포함했는지 검증
    private void validateContainZero(String input) {
        if (input.contains("0")) {
            throw new IllegalArgumentException("1 ~ 9 사이의 숫자만 입력해주세요.");
        }
    }

    // 중복수에 대한 검증
    private void validateDuplicateNumber(String input) {
        if (input.chars().distinct().count() < 3) {
            throw new IllegalArgumentException("중복된 수는 입력할 수 없습니다");
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
            throw new IllegalArgumentException("재시작은 1, 게임 종료는 2입니다.");
        }
    }

    private void validateSignLength(String input) {
        if (input.length() != 1) {
            throw new IllegalArgumentException("하나의 숫자만 입력해 주세요");
        }
    }
}
