package baseball.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public final class Validator {
    public static void validateUserInput(String input) {
        validateInput(input);
        validateInputSize(input);
        validateInputDuplication(input);
    }

    public static void validateInput(String input) {
        for (char c : input.toCharArray()) {
            if (!Character.isDigit(c) || c == '0') {
                throw new IllegalArgumentException("잘못된 값을 입력하였습니다. 프로그램을 종료합니다.");
            }
        }
    }

    public static void validateInputSize(String input) {
        int inputSize = input.length();
        if (inputSize != 3) {
            throw new IllegalArgumentException("3자리 숫자를 입력해야합니다. 프로그램을 종료합니다.");
        }
    }

    public static void validateRestartInput(String input) {
        if (input.equals("1") || input.equals("2")) {
            return;
        }
        throw new IllegalArgumentException("잘못된 값을 입력하였습니다. 프로그램을 종료합니다.");
    }

    public static void validateInputDuplication(String input) {
        List<Integer> inputNumbers = Arrays.stream(input.split(""))
                .map(Integer::valueOf)
                .collect(Collectors.toList());

        Set<Integer> setInputNumbers = new HashSet<>(inputNumbers);
        if (inputNumbers.size() != setInputNumbers.size()) {
            throw new IllegalArgumentException("사용자의 입력값에 중복된 숫자가 존재합니다. 프로그램을 종료합니다.");
        }
    }
}
