package baseball.utils;

import java.util.Arrays;
import java.util.List;

public class Common {
    List<Integer> stringToIntegerArray(String inputString) {
        return Arrays.stream(inputString.split(""))
                .mapToInt(Integer::parseInt)
                .boxed().toList();
    }
}
