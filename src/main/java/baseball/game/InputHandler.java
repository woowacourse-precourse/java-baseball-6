package baseball.game;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;

public class InputHandler {

    private static final int MAX_NUMBER_SIZE = 3;
    private static final Pattern NUMBER_PATTERN = Pattern.compile("^[1-9]+$");

    public String getPlayInput() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        validateInput(input);
        return input;
    }

    private void validateInput(String input) {
        validateIsNumber(input);
        validateNumberSize(input);
        validateNoDuplicate(input);
    }

    private void validateIsNumber(String input) {
        if (!NUMBER_PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException("숫자만 입력해주세요.");
        }
    }

    private void validateNumberSize(String input) {
        if (input.length() != MAX_NUMBER_SIZE) {
            throw new IllegalArgumentException(MAX_NUMBER_SIZE + "자리의 수를 입력해주세요.");
        }
    }

    private void validateNoDuplicate(String input) {
        long distinctCount = input.chars()
                .distinct()
                .count();
        if (distinctCount < input.length()) {
            throw new IllegalArgumentException("서로 다른 3자리의 수를 입력해주세요.");
        }
    }
}
