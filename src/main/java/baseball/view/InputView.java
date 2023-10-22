package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private InputView() {
    }

    public static String inputPositiveNumber() {
        String inputString = Console.readLine();
        validateBlankString(inputString);
        validateNumber(inputString);
        validatePositiveNumber(inputString);
        return inputString;
    }

    private static void validateBlankString(String string) {
        if (string.isBlank()) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }
    }

    private static void validateNumber(String string) {
        try {
            Integer.parseInt(string);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("문자, 특수기호 등을 제외한 숫자를 입력해주세요.");
        }
    }

    private static void validatePositiveNumber(String string) {
        if (Integer.parseInt(string) <= 0) {
            throw new IllegalArgumentException("양수의 숫자를 입력해주세요.");
        }
    }

}
