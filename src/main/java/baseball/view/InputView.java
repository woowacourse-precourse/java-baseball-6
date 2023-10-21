package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String readNumber(String message) {
        System.out.printf(message);
        String inputValue = Console.readLine();
        validateNumber(inputValue);
        return inputValue;
    }

    public static void validateNumber(String inputValue) {
        validateEmpty(inputValue);
        try {
            Integer.parseInt(inputValue);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }
    }

    private static void validateEmpty(String inputValue) {
        if (inputValue.isEmpty()) {
            throw new IllegalArgumentException("빈 값을 입력하였습니다.");
        }
    }
}
