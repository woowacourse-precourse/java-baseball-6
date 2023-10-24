package baseball.others;

import static baseball.others.Constant.numberOfNumbers;

public class ExceptionHandling {
    public static void digitsExceptionTesting(final String strNumber) {
        isNull(strNumber);
        isThree(strNumber);
        isDigits(strNumber);
        isDifferent(strNumber);
    }

    private static void isNull(final String strNumber) {
        if (strNumber.isBlank()) {
            throw new IllegalArgumentException("문자열이 비어있거나 빈 공백으로 이뤄져 있습니다. 게임을 종료합니다.");
        }
    }

    private static void isThree(final String strNumber) {
        if (strNumber.length() != numberOfNumbers) {
            throw new IllegalArgumentException("3자리 수를 입력하셔야 합니다. 게임을 종료합니다.");
        }
    }

    private static void isDigits(final String strNumber) {
        for (int i = 0; i < numberOfNumbers; i++) {
            char chNumber = strNumber.charAt(i);
            if (!(chNumber >= '1' && chNumber <= '9')) {
                throw new IllegalArgumentException("1~9까지의 숫자가 아닌 다른 값을 입력하셨습니다. 게임을 종료합니다.");
            }
        }
    }

    private static void isDifferent(final String strNumber) {
        String strTemp = "";
        for (int i = 0; i < numberOfNumbers; i++) {
            char chNumber = strNumber.charAt(i);
            if (!strTemp.contains(String.valueOf(chNumber))) {
                strTemp += String.valueOf(chNumber);
            } else {
                throw new IllegalArgumentException("입력한 수가 중복됩니다. 게임을 종료합니다.");
            }
        }
    }

    public static void restartException() {
        throw new IllegalArgumentException("게임을 새로 시작하려면 1, 종료하려면 2를 입력하셔야 합니다. 게임을 종료합니다.");
    }
}