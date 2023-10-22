package baseball.model;

import static baseball.Constant.PLAY_WANT;

public class ResumeNumber {

    private int resumeNumber;

    private ResumeNumber(final int number) {
        this.resumeNumber = number;
    }

    public static ResumeNumber createDefault() {
        return new ResumeNumber(PLAY_WANT.getValue());
    }

    public void updateNumber(final int number) {
        this.resumeNumber = number;
    }

    public boolean isWantMoreGame() {
        return resumeNumber == PLAY_WANT.getValue();
    }
}
