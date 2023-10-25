package baseball.user;

public class UserStatus {
    public static final String CONTINUE_COMMAND = "1";
    public static final String EXIT_COMMAND = "2";
    private final String status;

    public UserStatus(String status) {
        validateCommand(status);
        this.status = status;
    }

    public void validateCommand(String userInput) {
        if (!userInput.equals(CONTINUE_COMMAND) && !userInput.equals(EXIT_COMMAND)) {
            throw new IllegalArgumentException("1번 혹은 2번을 입력하세요.");
        }
    }

    public String getStatus() {
        return this.status;
    }
}
