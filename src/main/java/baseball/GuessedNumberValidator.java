package baseball;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import static baseball.NumberBaseballGameConfig.BASEBALL_NUMBER_LENGTH;

public class GuessedNumberValidator implements InputValidator {

    @Override
    public void validate(String input) {
        checkLength(input);
        checkType(input);
        checkDuplicate(input);
    }

    //중복 체크
    private static void checkDuplicate(String input) {
        List<Integer> guess = Arrays.stream(input.split(""))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
        if (new HashSet<>(guess).size() != BASEBALL_NUMBER_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    // 타입 확인
    private static void checkType(String input) {
        try {
            Integer.parseInt(input);
            return;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    // 길이 확인
    private static void checkLength(String input) {
        if (input.length() != BASEBALL_NUMBER_LENGTH) {
            throw new IllegalArgumentException();
        }
    }
}
