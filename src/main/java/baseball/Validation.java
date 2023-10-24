package baseball;

// 검증 기능들을 모아놓은 클래스
public class Validation {
    public static void validateInputNumber(String inputNumber) {
        checkInclusionString(inputNumber);
        checkLength(inputNumber);
        checkInclusionZero(inputNumber);
        checkDuplicate(inputNumber);
    }

    // 입력값 문자 포함 확인
    public static void checkInclusionString(String inputNumber) {
        try {
            int inputNumberToInteger = Integer.parseInt(inputNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INCLUSION_STRING_ERROR);
        }
    }

    // 숫자 중복 확인
    public static void checkDuplicate(String inputNumber) {
        int inputNumberToInt = Integer.parseInt(inputNumber);

        int firstDigit = inputNumberToInt / 100;
        int secondDigit = inputNumberToInt / 10 % 10;
        int thirdDigit = inputNumberToInt % 10;

        if (firstDigit == secondDigit || secondDigit == thirdDigit || firstDigit == thirdDigit) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBER_ERROR);
        }
    }

    // 숫자 0 포함 확인
    public static void checkInclusionZero(String inputNumber) {
        if (inputNumber.contains("0")) {
            throw new IllegalArgumentException(ErrorMessage.INCLUSION_ZERO_ERROR);
        }
    }

    // 글자 수 확인
    public static void checkLength(String inputNumber) {
        if (inputNumber.length() != 3) {
            throw new IllegalArgumentException(ErrorMessage.LENGTH_ERROR);
        }
    }

    public static void checkChoiceRestart(String inputNumber) {
        if (!inputNumber.equals(Player.GAME_RESTART) && !inputNumber.equals(Player.GAME_END)) {
            throw new IllegalArgumentException(ErrorMessage.CHOICE_NUMBER_ERROR);
        }
    }
}
