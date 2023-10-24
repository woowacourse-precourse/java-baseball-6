package baseball.model.player;

import static baseball.exception.GuessNumbersValidator.isGuessNumbersValid;
import static baseball.util.StringToGuessNumberListConverter.StringToGuessNumberList;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class GuessNumbers {

    private List<GuessNumber> numbers;

    public GuessNumbers() {
        this.numbers = new ArrayList<>();
    }

    public void input() {
        String input = Console.readLine();
        validateInputNumbers(input);
        List<GuessNumber> guessNumbers = StringToGuessNumberList(input);
        this.numbers = guessNumbers;
    }

    private void validateInputNumbers(String input) {
        if (!isGuessNumbersValid(input)) {
            throw new IllegalArgumentException();
        }
    }

    public List<GuessNumber> getNumbers() {
        return numbers;
    }
}
