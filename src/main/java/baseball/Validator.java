package baseball;

public class Validator {
    public void validateInputString(String inputString) {
        validateInputNoWhiteSpace(inputString);
        validateInputLength(inputString);
        validateInputNoZero(inputString);
    }
    private void validateInputLength(String inputString) {
        if (inputString.length() != 3) {
            throw new IllegalArgumentException("세자리 수를 입력하셔야 합니다.");
        }
    }

    private void validateInputNoWhiteSpace(String inputString) {
        if (inputString.contains(" ")) {
            throw new IllegalArgumentException("입력에는 공백이 포함되면 안됩니다.");
        }
    }

    private void validateInputNoZero(String inputString) {
        if (inputString.contains("0")) {
            throw new IllegalArgumentException("1~9의 수로 이루어져 있어야 합니다.");
        }
    }
}
