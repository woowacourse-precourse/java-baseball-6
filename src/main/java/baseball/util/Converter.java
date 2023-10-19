package baseball.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Converter {
    private Converter() {
    }

    public static List<Integer> convertList(String value) {
        return Arrays.stream(value.split(""))
                .map(String::valueOf)
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());

    }
}
