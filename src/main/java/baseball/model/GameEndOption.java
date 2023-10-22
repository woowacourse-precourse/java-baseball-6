package baseball.model;

public class GameEndOption {
    private final String resetNumber;

    public String getOptionValue() {
        return resetNumber;
    }

    public GameEndOption(String number) {
        validateOption(number);
        this.resetNumber = number;
    }

    public static void validateOption(String number) {
        if (!number.equals("1") && !number.equals("2")) {
            throw new IllegalArgumentException("1, 2가 아닌 다른 값을 입력했습니다.");
        }
    }
}
