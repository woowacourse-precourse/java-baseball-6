package baseball;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputValidation {

    public void validateLength(String input) {
        String trimmed = input.replace(" ", "");
        if (trimmed.length() != 3) {
            throw new IllegalArgumentException("3개의 숫자만 입력해주세요.");
        }
    }

    public List<Integer> convertStrToIntegerList(String input) {
        return Arrays.stream(input.split(""))
                .map(Integer::parseInt).collect(Collectors.toList());
    }

    public void validateSign(String input) {
        if (input.charAt(0) != '1' && input.charAt(0) != '2') {
            throw new IllegalArgumentException("재시작은 1, 게임 종료는 2입니다.");
        }
    }
}
