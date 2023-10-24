package baseball.util;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Input {
    private final InputValidator inputValidator;

    public Input(InputValidator inputValidator) {
        this.inputValidator = inputValidator;
    }

    public List<Integer> getUserNumbers() {
        String readLine = Console.readLine();
        inputValidator.validateDigits(readLine);

        List<Integer> numbers = splitFromString(readLine);
        validateNumbers(numbers);

        return numbers;
    }

    private static List<Integer> splitFromString(String readLine) {
        return Arrays.stream(readLine.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private void validateNumbers(List<Integer> numbers) {
        inputValidator.validateInputSize(numbers);
        inputValidator.validateDuplicate(numbers);
        inputValidator.validateNumberRange(numbers);
    }

    public String getCommandAfterGameWin() {
        String readCommand = Console.readLine();
        inputValidator.validateCommandAfterGame(readCommand);
        inputValidator.validateDigits(readCommand);
        return readCommand;
    }
}
