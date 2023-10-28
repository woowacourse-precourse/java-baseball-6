package baseball.util.validateCondition;

public enum RangeCondition {

    START(1),
    END(9);

    private final int number;

    RangeCondition(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public static boolean isNotInRange(int number) {
        return number < START.number || number > END.number;
    }


}
