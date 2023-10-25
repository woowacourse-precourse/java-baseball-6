package baseball.model;

import baseball.util.InputValidator;
import baseball.util.OutputUtils;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Player {

    private List<Integer> numbers;

    public void retrievePlayerNumber() {
        OutputUtils.printUserInputMessage();
        String input = Console.readLine();

        InputValidator.validatePlayerNumberInput(input);

        convertInputStringToIntegers(input);
    }

    public GameRestartState retrieveRestartNumber() {
        OutputUtils.printRestartGameMessage();
        return GameRestartState.findGameStateFromString(Console.readLine());
    }

    private void convertInputStringToIntegers(final String input) {
        this.numbers = new ArrayList<>();
        IntStream.range(0, input.length())
                .forEach(i -> this.numbers.add(input.charAt(i) - '0'));
    }

    public List<Integer> getNumbers() {
        if (this.numbers == null || this.numbers.isEmpty()) {
            this.retrievePlayerNumber();
        }
        return numbers;
    }

    public void setNumbers(List<Integer> numbers) {
        String convertedStr = InputValidator.convertListToString(numbers);
        InputValidator.validatePlayerNumberInput(convertedStr);

        this.numbers = numbers;
    }
}
