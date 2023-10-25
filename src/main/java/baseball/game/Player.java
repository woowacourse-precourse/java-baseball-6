package baseball.game;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Player {

    private List<Integer> numbers;

    public List<Integer> convertStringToIntList(String input) {
        List<Integer> numbers = Arrays.stream(input.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers(String input) {
        this.numbers = convertStringToIntList(input);
    }
}
