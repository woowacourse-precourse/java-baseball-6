package baseball.domain;

import java.util.Arrays;

public enum ReplayType {
    REPLAY("1", true),
    END("2", false);

    private final String command;
    private final boolean isReplay;


    ReplayType(String command, boolean isReplay) {
        this.command = command;
        this.isReplay = isReplay;
    }

    public static ReplayType findTypeByInput(String input) {
        return Arrays.stream(ReplayType.values())
                .filter(t -> t.command.equals(input))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }

    public boolean isReplay() {
        return isReplay;
    }
}
