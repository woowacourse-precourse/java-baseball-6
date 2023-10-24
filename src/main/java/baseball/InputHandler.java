package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;

public class InputHandler {

    private static final Pattern NUMBER_PATTERN = Pattern.compile("^[1-9]+$");

    public String getPlayInput() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        validateIsNumber(input);
        return input;
    }

    private void validateIsNumber(String input) {
        if (!NUMBER_PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException("숫자만 입력해주세요.");
        }
    }
}
