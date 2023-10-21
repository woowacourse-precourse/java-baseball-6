package baseball.validator;

public class InputValidate {

    private static final int BEGIN_ASCII_CODE = 48; // 숫자 0
    private static final int END_ASCII_CODE = 57; // 숫자 9
    private static final int MAX_NUMBER_LENGTH = 3;
    private static final String NON_NUMERIC_ERROR_MESSAGE = "숫자만 입력해주세요.";

    public void validateNumeric(String input) {
        String stringValue = String.valueOf(input);
        for (char c : stringValue.toCharArray()) {
            if (c < BEGIN_ASCII_CODE || c > END_ASCII_CODE) {
                throw new IllegalArgumentException(NON_NUMERIC_ERROR_MESSAGE);
            }
        }
    }
    
}
