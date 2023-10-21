package baseball.model;

import static baseball.Constants.PLAY_WANT;

public class ResumeNumber {

    private int resumeNumber;

    private ResumeNumber(final int number) {
        this.resumeNumber = number;
    }

    public static ResumeNumber from(final int number) {
        return new ResumeNumber(number);
    }

    public void updateNumber(final int number) {
        this.resumeNumber = number;
    }

    public boolean isWantMoreGame() {
        return resumeNumber == PLAY_WANT;
    }
}
