package baseball.enums;

public enum NumbersEnum {

    MIN_VALUE(1),
    MAX_VALUE(9),
    LENGTH(3);

    private final int value;


    NumbersEnum(int value) {
        this.value = value;
    }


    public int showValue() {
        return value;
    }


}
