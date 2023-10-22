package baseball.io;

import baseball.constant.RetryStatus;
import baseball.domain.AttemptNumbers;

import java.util.Arrays;
import java.util.List;

public class InputMapper {

    private static final String SPLIT_DELIMITER = "";

    public AttemptNumbers toAttemptNumbers(final String input) {
        final List<Integer> numbers =
                Arrays.stream(input.split(SPLIT_DELIMITER)).map(Integer::parseInt).toList();
        return new AttemptNumbers(numbers);
    }

    public RetryStatus toRetryStatus(final String input) {
        return RetryStatus.valueOfCommand(Integer.parseInt(input));
    }
}
