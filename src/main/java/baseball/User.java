package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.stream.Collectors;

import static baseball.Constants.*;

public class User {

    public static List<Integer> inputNumbers() {
        System.out.print(INPUT_NUMBERS_MESSAGE);
        String input = Console.readLine();
        return parseIntegers(input);
    }

    private static List<Integer> parseIntegers(String input) {
        return input.chars()
                .map(Character::getNumericValue)
                .boxed()
                .collect(Collectors.toList());
    }
}
