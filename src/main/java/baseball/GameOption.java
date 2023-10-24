package baseball;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public enum GameOption {
    RESTART("1"),
    END("2");

    private final String value;

    GameOption(String value) {
        this.value = value;
    }

    public static GameOption of(String value) {
        for(GameOption e: GameOption.values()) {
            if(e.value.equals(value)) {
                return e;
            }
        }
        throw new IllegalArgumentException(Message.INVALID_INPUT);
    }
}
