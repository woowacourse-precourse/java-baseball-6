package baseball.model;

import static baseball.converter.StringToIntegerListConverter.StringToList;
import static baseball.validator.InputValidator.isInputNumbersValid;
import static baseball.validator.InputValidator.isRestartOrExitValid;

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
