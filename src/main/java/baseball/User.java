package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.stream.Collectors;

import static baseball.Constants.*;

public class User {
    private List<Integer> numbers;

    public void inputNumbers() {
        System.out.print(INPUT_NUMBERS_MESSAGE);
        String input = Console.readLine();
        numbers = parseIntegers(input);
    }

    private List<Integer> parseIntegers(String input) {
        return input.chars()
                .map(Character::getNumericValue)
                .boxed()
                .collect(Collectors.toList());
    }
}
