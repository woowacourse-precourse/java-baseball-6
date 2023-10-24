package baseball.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.NoSuchElementException;
import java.util.regex.Pattern;

public class NumberBaseballGameInputView {


    public final String readUserInput() {
        String input = readNonNullInput();

        System.out.println(input);
        if (!isValidInput(input)) {
            throw new IllegalArgumentException("입력값은 3자리의 숫자여야 합니다.");
        }

        return input;
    }

    public final String readRestartResponseInput() {
        String input = readNonNullInput();
        System.out.println(input);
        if (!isValidRestartInput(input)) {
            throw new IllegalArgumentException("입력값은 1또는 2입니다.");
        }

        return input;
    }

    private static String readNonNullInput() {
        String input;
        try {
            input = Console.readLine();
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException("입력값을 제공해야 합니다.");
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
