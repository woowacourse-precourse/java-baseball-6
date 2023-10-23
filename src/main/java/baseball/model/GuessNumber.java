package baseball.model;

import static baseball.util.InputValidator.isInputNumbersValid;
import static baseball.util.StringToIntegerListConverter.StringToList;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class GuessNumber {

    private List<Integer> numbers;

    public void guess() {
        String input = Console.readLine();
        validateInputNumbers(input);
        this.numbers = StringToList(input);
    }

    private void validateInputNumbers(String input) {
        if (!isInputNumbersValid(input)) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
