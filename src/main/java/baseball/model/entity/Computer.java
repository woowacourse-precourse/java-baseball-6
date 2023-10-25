package baseball.model.entity;


public class Computer {
    private final Baseball baseballNumber;

    public Computer() {
        this.baseballNumber = new Baseball();
    }

    public Baseball getBaseballNumber() {
        return baseballNumber;
    }
}
