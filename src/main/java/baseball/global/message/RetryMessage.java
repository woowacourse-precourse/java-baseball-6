package baseball.global.message;

public enum RetryMessage {
    ONE("1"),
    TWO("2");

    private final String number;

    RetryMessage(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public static boolean compareInput(String input) {
        return input.equals(ONE.getNumber());
    }
}
