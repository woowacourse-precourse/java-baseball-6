package baseball.component;

public enum GeneralNumbers {

    NUMBER_SIZE(3);

    public int getCode() {
        return code;
    }

    GeneralNumbers(int code) {
        this.code = code;
    }

    private final int code;
}
