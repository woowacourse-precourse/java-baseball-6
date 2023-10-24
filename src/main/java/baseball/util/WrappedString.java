package baseball.util;

public class WrappedString {
    private final String value;

    public WrappedString(String value) {
        if (value == null || value.isEmpty()){
            throw new InvalidInputException("유효하지 않은 입력");
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
