package baseball.model;

public class ResumeNumber {

    private int resume;

    private ResumeNumber(final int resume) {
        this.resume = resume;
    }

    public static ResumeNumber from(final int number) {
        return new ResumeNumber(number);
    }

    public void updateNumber(final int number) {
        this.resume = number;
    }
}
