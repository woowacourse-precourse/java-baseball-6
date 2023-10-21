package baseball.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

import static baseball.exception.BaseballExceptionType.*;
import static baseball.view.BaseballConsoleConstants.INPUT_NUMBER;

public class InputView {
    public List<Integer> readThreeInputNumbers() {
        BaseballConsole.print(INPUT_NUMBER);
        String[] strings = Console.readLine().split(",");

        List<Integer> numbers = new ArrayList<>();
        for (String string : strings) {
            int number = Integer.parseInt(string.trim());
            validateNumberRange(number);
            validateNoDuplicate(numbers, number);
            numbers.add(number);
        }
        validateNumberCount(numbers);
        return numbers;
    }

    public boolean readContinueGame() {
        int gameOption = Integer.parseInt(Console.readLine());
        validateGameOption(gameOption);
        if (gameOption == 1) return true;
        return false;
    }

    public void validateNumberRange(int number) {
        if (number < 1 || number > 9) {
            throw new IllegalArgumentException(OUT_OF_RANGE.getMessage());
        }
    }

    public void validateNoDuplicate(List<Integer> numbers, int number) {
        if (numbers.contains(number)) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER.getMessage());
        }
    }

    public void validateNumberCount(List<Integer> numbers) {
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

