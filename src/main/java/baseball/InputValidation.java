package baseball;

public class InputValidation {
    public void validateUserInput(String input) throws IllegalArgumentException{
        if (input.contains(" ")) {
            throw new IllegalArgumentException("공백 없이 오직 숫자만 입력해주시기 바랍니다.");
        }
        if (input.contains(",")) {
            throw new IllegalArgumentException("콤마 없이 오직 숫자만 입력해주시기 바랍니다.");
        }
        if (input.length() != 3) {
            throw new IllegalArgumentException("3개의 숫자만을 입력해주시기 바랍니다.");
        }
    }
}
