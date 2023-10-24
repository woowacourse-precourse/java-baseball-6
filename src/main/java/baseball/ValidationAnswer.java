package baseball;

class ValidationAnswer extends Validation {
    private static final String answerErrorMessage = "각 자리 수가 1~9이며, 서로 중복되지 않는 3자리 수를 입력해주세요.";

    // 제시한 답에 대한 유효성 검사
    public static void isValid(String arg) {
        checkIsEmpty(arg, answerErrorMessage);
        checkIsNumber(arg, answerErrorMessage);
        checkAnswerIncludeZero(arg);
        checkAnswerLength(arg);
        checkAnswerRepeat(arg);
    }

    // 입력 유효성 검사: 0이 포함되어 있는가? - answer
    private static void checkAnswerIncludeZero(String arg) {
        for (int i = 0; i < 3; i++) {
            if (arg.charAt(i) == '0') {
                throw new IllegalArgumentException(answerErrorMessage);
            }
        }
    }

    // 입력 유효성 검사: 숫자이지만 3자리가 아닌 입력값 확인 - answer
    private static void checkAnswerLength(String arg) {
        if (arg.length() != 3) {
            throw new IllegalArgumentException(answerErrorMessage);
        }
    }

    // 입력 유효성 검사: 숫자이며, 3자리이지만 중복되는 입력값 확인 - answer
    private static void checkAnswerRepeat(String arg) {
        if (isRepeated(arg)) {
            throw new IllegalArgumentException(answerErrorMessage);
        }
    }

    private static boolean isRepeated(String arg) {
        return (arg.charAt(0) == arg.charAt(1) ||
                arg.charAt(0) == arg.charAt(2) ||
                arg.charAt(1) == arg.charAt(2));
    }
}