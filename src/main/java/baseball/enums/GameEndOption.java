package baseball.enums;

import java.util.Arrays;

public enum GameEndOption {
    RESTART("1"),
    END("2");

    private final String inputString;

    GameEndOption(String inputString) {
        this.inputString = inputString;
    }

    public String getValue() {
        return inputString;
    }

    public static GameEndOption fromString(String inputString) {
        return Arrays.stream(GameEndOption.values())
                .filter(option -> option.getValue().equals(inputString))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorCode.INVALID_GAME_END_OPTION.getMessage()));
    }
}
