package baseball.model;

public enum NumberRule {

    NUMBER_SIZE(3),
    NUMBER_RANGE_START(1),
    NUMBER_RANGE_END(9);

    private int number;

    NumberRule(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }


}
