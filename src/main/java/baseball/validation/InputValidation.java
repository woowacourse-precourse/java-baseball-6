package baseball.validation;

public class InputValidation {

    public static void Number (String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException("3자리의 숫자를 입력해주세요.");
        }
        if (!input.matches("^[1-9]*$")) {
            throw new IllegalArgumentException("숫자만 입력해주세요.");
        }
        if (input.contains(" ")) {
            throw new IllegalArgumentException("공백은 입력할 수 없습니다.");
        }
    }
}
