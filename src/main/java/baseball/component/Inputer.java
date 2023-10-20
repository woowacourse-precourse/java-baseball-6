package baseball.component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Inputer {

    private List<Integer> convertToDigit(String s) {
        List<Integer> input;
        try {
            input = Arrays.stream(s.split("")).mapToInt(Integer::parseInt).boxed()
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        return input;
    }
}
