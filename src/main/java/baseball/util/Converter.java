package baseball.util;

import java.util.Arrays;
import java.util.List;

public class Converter {

    public static List<Integer> toIntegerList(String str) {
        List<Integer> intList = Arrays.stream(str.trim().split(""))
                .mapToInt(Integer::parseInt)
                .boxed().toList();
        return intList;
    }
}
