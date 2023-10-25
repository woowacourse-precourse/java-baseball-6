package baseball.validation;

import baseball.utils.RequiredGameExitAnswer;

public class GameExitValidation {

    public static void validateExitAnswer(String exitAnswer) {
        if (!exitAnswer.equals(RequiredGameExitAnswer.CONTINUE_ANSWER.getMessage()) && !exitAnswer.equals(
                RequiredGameExitAnswer.EXIT_ANSWER.getMessage())) {
            throw new IllegalArgumentException("재시작 여부는 숫자 1 또는 2로 입력되어야 합니다.");
        }
    }
}
