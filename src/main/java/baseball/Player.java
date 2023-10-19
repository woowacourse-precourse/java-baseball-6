package baseball;

import java.util.Arrays;
import java.util.List;

public class Player {

    private List<Integer> numbers;

    public Player(String number) {
        this.numbers = convert(number);
    }

    private List<Integer> convert(String number) {
        return Arrays.stream(number.split(""))
                .map(Integer::parseInt)
                .toList();
    }
}
