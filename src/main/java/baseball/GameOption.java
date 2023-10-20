package baseball;

import java.util.Arrays;

public enum GameOption {
    CONTINUE(1),
    EXIT(2);

    private final int optionNumber;

    GameOption(final int optionNumber) {
        this.optionNumber = optionNumber;
    }

    public static GameOption of(final int optionNumber) {
        return Arrays.stream(values())
                .filter(option -> option.matchNumber(optionNumber))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    private boolean matchNumber(final int optionNumber) {
        return this.optionNumber == optionNumber;
    }

    public boolean isContinue() {
        return this == GameOption.CONTINUE;
    }
}
