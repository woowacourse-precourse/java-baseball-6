package baseball.logic;

public class InputValidator {

    public void validateLength(String inputNumbers) {
        if (inputNumbers.length() != 3) {
            throw new IllegalArgumentException("입력한 숫자의 길이를 확인하세요.");
        }
    }
}
