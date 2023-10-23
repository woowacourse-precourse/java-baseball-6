package baseball.constant;

public enum Constant {
    ZERO(0),
    NUMBER_SIZE(3),
    RESTART(1),
    QUIT(2);

    private final int constant;

    Constant(int constant) {
        this.constant = constant;
    }

    public int getConstant() {
        return constant;
    }
}
