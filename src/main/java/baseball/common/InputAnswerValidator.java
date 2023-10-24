package baseball.common;

public class InputAnswerValidator {

    public static final String WRONG_INPUT_ANSWER_MESSAGE = "1 또는 2 를 입력해주세요.";
    public static final String RESTART_YES_ANSWER = "1";
    public static final String RESTART_NO_ANSWER = "2";

    public static void validate(String inputAnswer) {
        if(!isYes(inputAnswer) && !isNo(inputAnswer)) {
            throw new IllegalArgumentException(WRONG_INPUT_ANSWER_MESSAGE);
        }
    }

    private static boolean isYes(String inputAnswer) {
        return inputAnswer.equals(RESTART_YES_ANSWER);
    }

    private static boolean isNo(String inputAnswer) {
        return inputAnswer.equals(RESTART_NO_ANSWER);
    }
}
