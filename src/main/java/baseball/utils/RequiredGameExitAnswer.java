package baseball.utils;

public enum RequiredGameExitAnswer {
    CONTINUE_ANSWER("1"),
    EXIT_ANSWER("2");
    private final String message;

    RequiredGameExitAnswer(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
