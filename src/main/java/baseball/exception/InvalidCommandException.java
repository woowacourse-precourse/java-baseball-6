package baseball.exception;

public class InvalidCommandException extends IllegalArgumentException {
    private static final String errorMessage = "잘못된 명령어 입력";

    public InvalidCommandException() {
        super(errorMessage);
    }
}
