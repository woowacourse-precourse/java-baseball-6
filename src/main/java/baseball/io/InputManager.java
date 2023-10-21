package baseball.io;

import baseball.constant.RetryStatus;
import baseball.domain.AttemptNumbers;

import java.util.Arrays;
import java.util.List;

public class InputManager {

    private static final String SPLIT_DELIMITER = "";
    private final InputView inputView;

    public InputManager(final InputView inputView) {
        this.inputView = inputView;
    }

    public AttemptNumbers readAttemptNumbers() {
        final String input = inputView.readAttemptNumbers();
        final List<Integer> numbers = mapToNumbers(input);

        return new AttemptNumbers(numbers);
    }

    private List<Integer> mapToNumbers(final String input) {
        return Arrays.stream(input.split(SPLIT_DELIMITER)).map(Integer::parseInt).toList();
    }

    public RetryStatus readRetry() {
        final String input = inputView.readRetry();
        return RetryStatus.valueOfCommand(Integer.parseInt(input));
    }
}
