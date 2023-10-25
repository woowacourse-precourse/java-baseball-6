package baseball.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Parser {
    public static List<Integer> parseNumbers(String numbers) {
        return Arrays.stream(numbers.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static Integer parseRestartOrExit(String restartOrExit) {
        return Integer.parseInt(restartOrExit);
    }
}
