package validation;

import static constant.Constant.NUMBER_OF_DIGITS;

public class BaseballGameInputValidator {
    public static void validateInput(String inputString) {
        if (inputString.length() > NUMBER_OF_DIGITS) {
            throw new IllegalArgumentException("[ERROR] 길이가 잘못되었습니다. (입력받은 수: " + inputString.length() + ")");
        }
        for (int i = 0; i < inputString.length(); i++) {
            if (!Character.isDigit(inputString.charAt(i))) {
                throw new IllegalArgumentException("[ERROR] 입력값은 숫자로만 이루어져야 합니다.");
            }
        }
    }
}