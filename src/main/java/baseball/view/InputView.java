package baseball.view;

import static baseball.exception.BaseballExceptionType.DUPLICATE_NUMBER;
import static baseball.exception.BaseballExceptionType.INVALID_GAME_OPTION;
import static baseball.exception.BaseballExceptionType.INVALID_NUMBER_COUNT;
import static baseball.exception.BaseballExceptionType.OUT_OF_RANGE;
import static baseball.view.BaseballConsoleConstants.INPUT_NUMBER;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    public List<Integer> readThreeInputNumbers() {
        BaseballConsole.print(INPUT_NUMBER);

        String[] splitNumbers = Console.readLine().split("");
        List<Integer> numbers = Arrays.stream(splitNumbers)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        validateNumbers(numbers);
        return numbers;
    }

    public boolean readContinueGame() {
        int gameOption = Integer.parseInt(Console.readLine());
        validateGameOption(gameOption);
        if (gameOption == 1) {
            return true;
        }
        return false;
    }

    private void validateNumbers(List<Integer> numbers) {
        for (int number : numbers) {
            validateNumberRange(number);
            validateNoDuplicate(numbers, number);
        }
        validateNumberCount(numbers);
    }


    private void validateNumberRange(int number) {
        if (number < 1 || number > 9) {
            throw new IllegalArgumentException(OUT_OF_RANGE.getMessage());
        }
    }

    private void validateNoDuplicate(List<Integer> numbers, int number) {
        long count = numbers.stream().filter(n -> n == number).count();
        if (count > 1) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER.getMessage());
        }
    }

    private void validateNumberCount(List<Integer> numbers) {
        if (numbers.size() != 3) {
            throw new IllegalArgumentException(INVALID_NUMBER_COUNT.getMessage());
        }
    }

    private void validateGameOption(int gameOption) {
        if (gameOption != 1 && gameOption != 2) {
            throw new IllegalArgumentException(INVALID_GAME_OPTION.getMessage());
        }
    }
}

