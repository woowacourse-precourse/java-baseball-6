package baseball.io;

import baseball.constant.RetryStatus;
import baseball.domain.AttemptNumbers;

public class InputManager {

    private final InputView inputView;
    private final InputMapper inputMapper;

    public InputManager(final InputView inputView, final InputMapper inputMapper) {
        this.inputView = inputView;
        this.inputMapper = inputMapper;
    }

    public AttemptNumbers readAttemptNumbers() {
        final String input = inputView.readAttemptNumbers();
        return inputMapper.toAttemptNumbers(input);
    }

    public RetryStatus readRetry() {
        final String input = inputView.readRetry();
        return inputMapper.toRetryStatus(input);
    }
}
