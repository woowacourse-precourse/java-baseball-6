package baseball.model.player;

import static baseball.exception.GuessNumberValidator.isGuessNumbersValid;
import static baseball.util.StringToIntegerListConverter.StringToIntegerList;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class GuessNumber {

    private List<Integer> numbers;

    public GuessNumber() {
        this.numbers = new ArrayList<>();
    }

    public void input() {
        String input = Console.readLine();
        validateInputNumbers(input);
        this.numbers = StringToIntegerList(input);
    }

    private void validateInputNumbers(String input) {
        if (!isGuessNumbersValid(input)) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
