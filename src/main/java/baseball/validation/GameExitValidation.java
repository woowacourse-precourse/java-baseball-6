package baseball.validation;

public class GameExitValidation {
    private final static String validateContinueAnswer = "1";
    private final static String validateExitAnswer = "2";

    public static void validateExitAnswer(String exitAnswer) {
        if (!exitAnswer.equals(validateContinueAnswer) && !exitAnswer.equals(validateExitAnswer)) {
            throw new IllegalArgumentException("재시작 여부는 숫자 1 또는 2로 입력되어야 합니다.");
        }
    }
}
