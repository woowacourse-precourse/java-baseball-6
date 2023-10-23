package baseball.util;

import java.util.Arrays;
import java.util.List;

public class TypeConvertor {

    public static List<Integer> stringToIntegerList(String input) {
        try {
            return Arrays.stream(input.split(""))
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.ONLY_NUMBER.getMessage());
        }
    }
}
