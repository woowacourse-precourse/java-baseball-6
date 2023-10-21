package baseball.model;

import baseball.validation.NumberValidation;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PlayerNumber {
    private final List<Integer> number;

    public PlayerNumber(String str) {
        this.number = createPlayerNumber(str);
    }

    public List<Integer> createPlayerNumber(String str) {
        List<Integer> number = convertStringToInt(str);
        NumberValidation.validateInput(number);
        return number;
    }

    public List<Integer> convertStringToInt(String str) {
        int[] arr = Stream.of(str.split(""))
            .mapToInt(Integer::parseInt)
            .toArray();
        return Arrays.stream(arr)
            .boxed()
            .collect(Collectors.toList());
    }

    public List<Integer> getPlayerNumber() {
        return this.number;
    }
}
