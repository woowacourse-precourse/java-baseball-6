package baseball.model;

import static baseball.util.converter.StringToIntegerListConverter.StringToList;
import static baseball.util.validator.InputValidator.isInputNumbersValid;
import static baseball.util.validator.InputValidator.isRestartOrExitValid;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Player {

    private List<Integer> numbers;
    private Integer restartOrExit;

    public void inputNumbers() {
        String input = Console.readLine();
        validateInputNumbers(input);
        this.numbers = StringToList(input);
    }

    public void inputRestartOrExit() {
        String input = Console.readLine();
        validateInputRestartOrExit(input);
        this.restartOrExit = Integer.parseInt(input);
    }

    private void validateInputNumbers(String input) {
        if (!isInputNumbersValid(input)) {
            throw new IllegalArgumentException();
        }
    }

    private void validateInputRestartOrExit(String input) {
        if (!isRestartOrExitValid(input)) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public Integer getRestartOrExit() {
        return restartOrExit;
    }
}
