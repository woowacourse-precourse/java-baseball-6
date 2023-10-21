package baseball.exception;

import static java.util.Objects.isNull;

public class InputValidator {

    public static void validateAnswer(String sentence) throws InputException {
        if (isNull(sentence)) {
            throw new InputException("입력값에 Null 값이 확인되었습니다.");
        }

        if (isNotNumeric(sentence)) {
            throw new InputException("입력값이 숫자가 아닙니다.");
        }

        if (isTooShort(sentence)) {
            throw new InputException("입력값의 길이가 2이하입니다.");
        }

        if (isTooLong(sentence)) {
            throw new InputException("입력값의 길이가 4이상입니다.");
        }
    }

    private static boolean isNotNumeric(String sentence) {
        return !sentence.matches("\\d+");
    }

    private static boolean isTooLong(String sentence) {
        return sentence.length() > 3;
    }

    private static boolean isTooShort(String sentence) {
        return sentence.length() < 3;
    }
}
