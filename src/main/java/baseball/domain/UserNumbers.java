package baseball.domain;

import java.util.*;

import static java.util.stream.Collectors.toList;

public class UserNumbers {

    public static List<Integer> generate(String input) {
        isNumber(input);
        isThreeLength(input);
        duplicateCheck(input);

        return Arrays.stream(input.split(""))
                .map(Integer::parseInt)
                .collect(toList());
    }

    private static void isNumber(String input) {
        if (!input.matches("^[1-9]*$")) {
            throw new IllegalArgumentException("[ERROR] 1~9까지의 숫자만 입력이 가능합니다.");
        }
    }

    private static void isThreeLength(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException("[ERROR] 3자리 입력만 가능합니다.");
        }
    }

    private static void duplicateCheck(String input) {
        Set<String> duplicateCheck = new HashSet<>(Arrays.asList(input.split("")));
        if (duplicateCheck.size() != 3) {
            throw new IllegalArgumentException("[ERROR] 서로 다른 수만 입력이 가능합니다.");
        }
    }
}
