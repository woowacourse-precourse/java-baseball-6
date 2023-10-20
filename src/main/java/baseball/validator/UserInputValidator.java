package baseball.validator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

public class UserInputValidator {

    private UserInputValidator() {
    }

    public static final Pattern NUMBER_PATTERN = Pattern.compile("^[1-9]+$");

    public static void validateIsNumberAndRange(String userInput) {

        if (!NUMBER_PATTERN.matcher(userInput).matches()) {
            throw new IllegalArgumentException("[ERROR] 1~9 까지의 숫자만 입력 가능합니다.");
        }
    }

    public static void validateLength(String userInput) {
        if (userInput.length() != 3) {
            throw new IllegalArgumentException("[ERROR] 3자리 수만 입력 가능합니다.");
        }
    }

    public static void validateFinishOrRestart(String userInput) {
        if (!userInput.equals("1") && !userInput.equals("2")) {
            throw new IllegalArgumentException("[ERROR] 1 또는 2 의 값만 입력 가능합니다.");
        }
    }

    public static void validateDuplicate(String userInput) {
        List<Integer> list = Arrays.stream(userInput.split("")).map(Integer::parseInt).toList();
        for (Integer i : list) {
            if (Collections.frequency(list, i) > 1) {
                throw new IllegalArgumentException("[ERROR] 같은 숫자는 1번만 입력 가능합니다.");
            }
        }

    }
}
