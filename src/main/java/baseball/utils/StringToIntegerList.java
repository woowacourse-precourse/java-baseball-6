package baseball.utils;

import java.util.Arrays;
import java.util.List;

public class StringToIntegerList {

    public static List<Integer> toIntegerList(String userInput) {
        return Arrays.stream(userInput.split("")).map(Integer::parseInt).toList();
    }
}
