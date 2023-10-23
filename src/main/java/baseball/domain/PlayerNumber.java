package baseball.domain;

import java.util.List;
import java.util.stream.Collectors;

public class PlayerNumber extends Number {
    private PlayerNumber(List<Integer> numbers) {
        super(numbers);
    }

    public static PlayerNumber from(String input) {
        List<Integer> playerNumbers = input.chars()
                .map(c -> c - '0')
                .boxed()
                .collect(Collectors.toList());
        return new PlayerNumber(playerNumbers);
    }
}
