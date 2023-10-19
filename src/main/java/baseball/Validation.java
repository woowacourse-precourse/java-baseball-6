package baseball;

public class Validation {
    char restart = '1';
    char end = '2';

    public void validateContinueSign(String input) {
        if (input.length() != 1) {
            throw new IllegalArgumentException("1 혹은 2만 입력해 주세요.");
        }
        if (input.charAt(0) != restart && input.charAt(0) != end) {
            throw new IllegalArgumentException("재시작은 1, 종료는 2 입니다.");
        }
    }
}
