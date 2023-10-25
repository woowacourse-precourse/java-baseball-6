package baseball.model;

public class RetryOption {

    private final String value;

    public RetryOption(String value) {
        validate(value);
        this.value = value;
    }

    private void validate(String value) {
        if (!value.equals("1") && !value.equals("2")) {
            throw new IllegalArgumentException("재시작 옵션은 1 또는 2여야 합니다.");
        }
    }

    public String getValue() {
        return value;
    }
}
