package baseball.model.number;

import static baseball.Constant.END_WANT;
import static baseball.Constant.PLAY_WANT;

public class ResumeNumber {

    private static final int RESUME_ANSWER_LENGTH = 1;

    private final int resumeNumber;

    private ResumeNumber(final String answer) {
        validateAnswer(answer);
        this.resumeNumber = Integer.parseInt(answer);
    }

    public static ResumeNumber from(final String answer) {
        return new ResumeNumber(answer);
    }

    public static ResumeNumber createDefault() {
        return new ResumeNumber(PLAY_WANT.toString());
    }

    private void validateAnswer(final String answer) {
        validateAnswerLength(answer);
        validateAnswerValue(answer);
    }

    private void validateAnswerLength(final String answer) {
        if (answer.length() != RESUME_ANSWER_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    private void validateAnswerValue(final String answer) {
        if ((!answer.equals(PLAY_WANT.toString())) && (!answer.equals(END_WANT.toString()))) {
            throw new IllegalArgumentException();
        }
    }

    public boolean isWantMoreGame() {
        return resumeNumber == PLAY_WANT.getValue();
    }
}
