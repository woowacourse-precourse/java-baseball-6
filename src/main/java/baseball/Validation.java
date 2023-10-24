package baseball;

// 검증 기증들을 모아놓은 클래스
public class Validation {
    public static final String WRONG_INPUT_EXCEPTION = "잘못된 입력입니다. 게임을 종료합니다.";

    public static void validateInputNumber(String inputNumber) {
        try {
            checkInclusionString(inputNumber);
            checkLength(inputNumber);
            checkInclusionZero(inputNumber);
            checkDuplicate(inputNumber);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(WRONG_INPUT_EXCEPTION);
        }

    }

    // 입력값 문자 포함 확인
    public static void checkInclusionString(String inputNumber) {
        try {
            int inputNumberToInteger = Integer.parseInt(inputNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(WRONG_INPUT_EXCEPTION);
        }
    }

    // 숫자 중복 확인
    public static void checkDuplicate(String inputNumber) {
        int inputNumberToInt = Integer.parseInt(inputNumber);

        int firstDigit = inputNumberToInt / 100;
        int secondDigit = inputNumberToInt / 10 % 10;
        int thirdDigit = inputNumberToInt % 10;

        if (firstDigit == secondDigit || secondDigit == thirdDigit || firstDigit == thirdDigit) {
            throw new IllegalArgumentException(WRONG_INPUT_EXCEPTION);
        }
    }

    // 숫자 0 포함 확인
    public static void checkInclusionZero(String inputNumber) {
        if (inputNumber.contains("0")) {
            throw new IllegalArgumentException(WRONG_INPUT_EXCEPTION);
        }
    }

    // 글자 수 확인
    public static void checkLength(String inputNumber) {
        if (inputNumber.length() != 3) {
            throw new IllegalArgumentException(WRONG_INPUT_EXCEPTION);
        }
    }
}
