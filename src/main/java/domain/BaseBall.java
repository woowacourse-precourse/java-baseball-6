package domain;

public class BaseBall {
    private static final int MINIMUN = 1;
    private static final int MAXIMIN = 9;
    private final int baseballNumber;


    public BaseBall(Character baseballNumber) {
        this.baseballNumber = Character.getNumericValue(baseballNumber);
    }
}
