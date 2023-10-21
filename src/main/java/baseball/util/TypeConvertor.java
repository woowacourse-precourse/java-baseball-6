package baseball.util;

import java.util.Arrays;
import java.util.List;

public class TypeConvertor {

    public static List<Integer> stringToIntergerList(String input) {
        try {
            return Arrays.stream(input.split(""))
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력해주세요");
        }
    }
}
