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
    public void validateLength(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException("3개의 숫자만 입력해주세요.");
        }
    }

    public String deleteSpace(String input) {
        return input.replace(" ", "");
    }

    // 숫자로만 이루어져있는지 검증
    public void validateOnlyDigit(String input) {
        boolean checkOnlyDigit = input.chars().allMatch(Character::isDigit);

        if (!checkOnlyDigit) {
            throw new IllegalArgumentException("숫자만 입력해 주세요.");
        }
    }

    // 0을 포함했는지 검증
    public void validateContainZero(String input) {
        if (input.contains("0")) {
            throw new IllegalArgumentException("1 ~ 9 사이의 숫자만 입력해주세요.");
        }
    }

    // 중복수에 대한 검증
    public void validateDuplicateNumber(String input) {
        if (input.chars().distinct().count() < 3) {
            throw new IllegalArgumentException("중복된 수는 입력할 수 없습니다");
        }
    }

    // 문자열 -> 리스트 변환
    /*
    * 드디어 stream 써보는군아~~
    * 타입 변환할 때, for문을 돌면서 작업할 때. 공부하던거 드디어 쓴당!!
    * 머가 더 가독성 좋을까??
    * */
    public List<Integer> convertStrToIntegerList(String input) {
        return input.chars()
                .mapToObj(Character::getNumericValue)
                .collect(Collectors.toList());
    }

    public void validateSign(String input) {
        if (input.charAt(0) != '1' && input.charAt(0) != '2') {
            throw new IllegalArgumentException("재시작은 1, 게임 종료는 2입니다.");
        }
    }

    public void validateSignLength(String input) {
        if (input.length() != 1) {
            throw new IllegalArgumentException("재시작은 1, 게임 종료는 2입니다.");
        }
    }
}
