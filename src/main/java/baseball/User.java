package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.stream.Collectors;

import static baseball.Constants.*;

public class User {
    private Numbers numbers;

    public void inputNumbers() {
        System.out.print(INPUT_NUMBERS_MESSAGE);
        String input = Console.readLine();
        validateIntegerType(input);
        numbers = new Numbers(parseIntegers(input));
    }

    public GameCommand inputGameCommand() {
        System.out.println(INPUT_GAME_COMMAND_MESSAGE);
        String input = Console.readLine();
        validateIntegerType(input);
        return GameCommand.findByCommand(parseInteger(input));
    }

    private List<Integer> parseIntegers(String input) {
        return input.chars()
                .map(Character::getNumericValue)
                .boxed()
                .collect(Collectors.toList());
    }

    private Integer parseInteger(String input) {
        return Integer.parseInt(input);
    }

    public List<Integer> getNumbers() {
        return numbers.getNumbers();
    }

    private static void validateIntegerType(String input) {
        try {
            Integer.parseInt(input);
        } catch (IllegalArgumentException exception) {
            throw new IllegalArgumentException(INTEGER_TYPE_ERROR);
        }
    }
}
