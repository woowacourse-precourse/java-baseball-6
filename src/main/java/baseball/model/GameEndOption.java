package baseball.model;

public class GameEndOption {
    private final String resetNumber;
    private static final String RESET_COMMAND = "1";
    private static final String END_COMMAND = "2";

    public GameEndOption(String number) {
        validateOption(number);
        this.resetNumber = number;
    }

    private void validateOption(String number) {
        if (!number.equals(RESET_COMMAND) && !number.equals(END_COMMAND)) {
            throw new IllegalArgumentException("잘못된 값을 입력했습니다.");
        }
    }

    public boolean isReset() {
        return resetNumber.equals(RESET_COMMAND);
    }
}
