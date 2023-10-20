package client;

import java.util.Arrays;

public enum Option {
    CONTINUE("1"), FINISH("2"), ERROR("");

    private final String status;

    Option(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public static Option findByStatus(String status) {
        return Arrays.stream(Option.values())
                .filter(option -> status.equals(option.getStatus()))
                .findAny()
                .orElse(Option.ERROR);
    }
}
