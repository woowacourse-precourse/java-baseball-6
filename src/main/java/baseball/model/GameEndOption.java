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
        if (!RESET_COMMAND.equals(number) && !END_COMMAND.equals(number)) {
            throw new IllegalArgumentException("잘못된 값을 입력했습니다.");
        }
    }

    public boolean isReset() {
        return RESET_COMMAND.equals(resetNumber);
    }
}
