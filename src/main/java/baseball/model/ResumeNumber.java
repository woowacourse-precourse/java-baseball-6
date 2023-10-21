package baseball.model;

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
}
