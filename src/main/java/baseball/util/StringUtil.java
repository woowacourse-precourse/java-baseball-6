package baseball.util;

import java.util.Arrays;
import java.util.List;

public class StringUtil {
    public static List<Integer> convertStringToIntList(String numbers) {
        return Arrays.stream(numbers.split(""))
                .map(Integer::parseInt)
                .toList();
    }

    public static Integer convertStringToInt(String number) {
        return Integer.parseInt(number);
    }
}
