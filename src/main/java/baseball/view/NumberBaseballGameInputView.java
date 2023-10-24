package baseball.view;

import java.util.regex.Pattern;

public class NumberBaseballGameInputView {
    private final InputProvider inputProvider;

    public NumberBaseballGameInputView(InputProvider inputProvider) {
        this.inputProvider = inputProvider;
    }

    public final String readUserInput() {
        String input = inputProvider.readNonNullInput();

        System.out.println(input);
        if (!isValidInput(input)) {
            throw new IllegalArgumentException("입력값은 3자리의 숫자여야 합니다.");
        }

        return input;
    }

    public final String readRestartResponseInput() {
        String input = inputProvider.readNonNullInput();
        System.out.println(input);
        if (!isValidRestartInput(input)) {
            throw new IllegalArgumentException("입력값은 1또는 2입니다.");
        }

        return input;
    }


    private boolean isValidInput(String str) {
        return Pattern.matches("[0-9]{3}", str);
    }

    private boolean isValidRestartInput(String str) {
        return Pattern.matches("[1-2]", str);
    }


}
