package baseball;

public enum Command {
    RESTART, END;

    boolean isEnd() {
        return this == END;
    }

    public static Command findByCommand(String value) {
        if (value.equals("1")) {
            return RESTART;
        }
        return END;
    }
}
