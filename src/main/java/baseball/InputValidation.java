package baseball;

import java.util.regex.Pattern;

public class InputValidation {

    private InputValidation() {
    }

    public static void checkUserNumber(String input) {
        //입력 값(input)이 1부터 9까지의 서로 다른 3개의 숫자가 아니면 예외 발생
        if (!Pattern.matches("^(?!([0-9]).*?\\1)[1-9]{3}$", input)) {
            throw new IllegalArgumentException("1~9 사이의 서로 다른 3개의 숫자를 입력해주세요.");
        }
    }

    public static void checkRestartNumber(String input) {
        //입력 값(input)이 1 또는 2가 아니면 예외 발생
        if (!Pattern.matches("^[1-2]$", input)) {
            throw new IllegalArgumentException("1 또는 2를 입력해주세요.");
        }
    }
}
