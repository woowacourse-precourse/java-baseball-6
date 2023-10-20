package baseball.component;

import java.util.*;
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
        validate(input);
        return input;
    }

    private void validate(List<Integer> numbers) {
        Set<Integer> validateSet = new HashSet<>(numbers);
        if (validateSet.size() != 3 || numbers.size() != 3) {
            throw new IllegalArgumentException();
        }
    }
}
