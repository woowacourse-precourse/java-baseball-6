package baseball.view;

import baseball.domain.model.BaseballNumber;
import baseball.domain.util.BaseballInputPatterns;
import java.util.regex.Pattern;

public class NumberBaseballGameInputView {
    private final InputProvider<String> inputProvider;

    public NumberBaseballGameInputView(InputProvider<String> inputProvider) {
        this.inputProvider = inputProvider;
    }

    public final BaseballNumber readUserInput() {
        String input = inputProvider.readNonNullInput();
        BaseballInputPatterns.THREE_DIGIT_PATTERN.validate(input);
        return new BaseballNumber(input);
    }

    public final String readRestartResponseInput() {
        String input = inputProvider.readNonNullInput();
        BaseballInputPatterns.RESTART_PATTERN.validate(input);
        return input;
    }


}
