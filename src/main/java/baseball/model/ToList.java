package baseball.model;

import java.util.Arrays;
import java.util.List;

public class ToList {

    static List<Integer> toIntegerList(String userInput) {
        return Arrays.stream(userInput.split("")).map(Integer::parseInt).toList();
    }
}
