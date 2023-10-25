package baseball.util;

import baseball.model.InputNumbers;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class InputUtils {
    public static final int INPUT_NUMBERS_SIZE = 3;
    public static final Pattern INPUT_NUMBERS_IN_SIZE_PATTERN = Pattern.compile("^[1-9]{" + INPUT_NUMBERS_SIZE + "}$");

    public static List<Integer> inputNumbersToIntegerList(InputNumbers inputNumbers) {
        String value = inputNumbers.value();

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < value.length(); i++) {
            list.add(value.charAt(i) - '0');
        }
        return list;
    }
}
