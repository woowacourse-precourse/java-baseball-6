package baseball.util.validateCondition;

public enum LengthCondition {

    LENGTH(3);

    private final int length;

    LengthCondition(int length) {
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public static boolean isNotValid(int length) {
        return length != LENGTH.length;
    }
}
