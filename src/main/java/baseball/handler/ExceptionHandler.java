package baseball.handler;

public class ExceptionHandler {

    public static void validateNumbers(String inputNums) {
        // 7. 사용자가 3개의 숫자만 입력해야 하는데 4개의 수를 입력했을 때
        if (inputNums.length() != 3) {
            throw new IllegalArgumentException("3개의 숫자를 입력해야 합니다.");
        }
        // 8. 사용자가 1~9사이의 숫자만 입력하지 않고, 0을 입력했을 때
        if (inputNums.contains("0")) {
            throw new IllegalArgumentException("1~9사이의 숫자를 입력해야 합니다.");
        }
    }

    public static void validateNumber(String inputNum) {
        if (inputNum != "1" || inputNum != "2") {
            throw new IllegalArgumentException("1또는 2를 입력해야 합니다.");
        }
    }
}
