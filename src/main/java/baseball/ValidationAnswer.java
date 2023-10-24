package baseball;

class ValidationAnswer extends Validation {
    private static final String answerErrorMessage = "각 자리 수가 1~9이며, 서로 중복되지 않는 3자리 수를 입력해주세요.";

    // 제시한 답에 대한 유효성 검사
    public static void isValid(String answer) {
        checkIsEmpty(answer, answerErrorMessage);
        checkIsNumber(answer, answerErrorMessage);
        checkAnswerIncludeZero(answer);
        checkAnswerLength(answer);
        checkAnswerRepeat(answer);
    }

    // 입력 유효성 검사: 0이 포함되어 있는가?
    private static void checkAnswerIncludeZero(String answer) {
        for (int i = 0; i < 3; i++) {
            if (answer.charAt(i) == '0') {
                throw new IllegalArgumentException(answerErrorMessage);
            }
        }
    }

    // 입력 유효성 검사: 숫자이지만 3자리가 아닌 입력값 확인
    private static void checkAnswerLength(String answer) {
        if (answer.length() != 3) {
            throw new IllegalArgumentException(answerErrorMessage);
        }
    }

    // 입력 유효성 검사: 숫자이며, 3자리이지만 중복되는 입력값 확인
    private static void checkAnswerRepeat(String answer) {
        if (isRepeated(answer)) {
            throw new IllegalArgumentException(answerErrorMessage);
        }
    }

    private static boolean isRepeated(String answer) {
        return (answer.charAt(0) == answer.charAt(1) ||
                answer.charAt(0) == answer.charAt(2) ||
                answer.charAt(1) == answer.charAt(2));
    }
}
