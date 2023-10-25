package baseball.enums;

import java.util.Arrays;

public enum GameContinuationOption {
    RESTART("1"),
    END("2");

    private final String inputString;

    GameContinuationOption(String inputString) {
        this.inputString = inputString;
    }

    public String getValue() {
        return inputString;
    }

    public static GameContinuationOption fromString(String inputString) {
        return Arrays.stream(GameContinuationOption.values())
                .filter(option -> option.getValue().equals(inputString))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorCode.INVALID_GAME_END_OPTION.getMessage()));
    }
}
