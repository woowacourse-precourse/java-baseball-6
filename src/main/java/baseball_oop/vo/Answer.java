package baseball_oop.vo;

import baseball_oop.enums.ExceptionMessage;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Answer {
    List<Integer> values;
    private final static int LENGTH_LIMIT = 3;

    public Answer() {
        Set<Integer> set = new HashSet<>();
        while (set.size() < LENGTH_LIMIT) {
            set.add(pickNumberInRange(1, 9));
        }
        this.values = set.stream().toList();
    }


    public Answer(String input) {
        checkValidation(input);
        this.values = Arrays.stream(input.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static void checkValidation(String value) {
        checkLength(value);
        checkDuplicate(value);
        checkNumber(value);
    }

    private static void checkDuplicate(String value) {
        if (hasDuplicate(value)) {
            throw new IllegalArgumentException(ExceptionMessage.WRONG_INPUT_DUPLICATE_VALUE.getMessage());
        }
    }

    private static void checkLength(String value) {
        if (!isLimitedLength(value)) {
            throw new IllegalArgumentException(ExceptionMessage.WRONG_INPUT_NOT_THREE_DIGITS.getMessage());
        }
    }

    private static void checkNumber(String value) {
        if (!isNumber(value)) {
            throw new IllegalArgumentException(ExceptionMessage.WRONG_INPUT_NOT_NUMBER.getMessage());
        }
    }

    private static boolean isLimitedLength(String value) {
        return value.length() == LENGTH_LIMIT;
    }

    private static boolean hasDuplicate(String value) {
        Set<String> set = new HashSet<>();
        for (String str : value.split("")) {
            set.add(str);
        }
        return set.size() != value.length();
    }

    private static boolean isNumber(String value) {
        return value != null && value.matches("[-+]?\\d*\\.?\\d+");
    }

    public Result compare(Answer input) {
        return null;
    }
}
