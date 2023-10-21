package baseball;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UserNumberGenerator {
    public List<Integer> generate(String numbers) {
        return Arrays.stream(numbers.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
