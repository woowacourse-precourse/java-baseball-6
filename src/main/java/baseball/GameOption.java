package baseball;

import static java.util.stream.Collectors.toMap;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

public enum GameOption {
    CONTINUE(1),
    EXIT(2);

    private static final Map<Integer, GameOption> options =
            Collections.unmodifiableMap(Stream.of(values()).collect(
                    toMap(GameOption::getNumber, option -> option)
            ));

    private final int optionNumber;

    GameOption(final int optionNumber) {
        this.optionNumber = optionNumber;
    }

    public static Optional<GameOption> find(final int optionNumber) {
        return Optional.ofNullable(options.get(optionNumber));
    }

    private int getNumber() {
        return optionNumber;
    }

    public boolean isContinue() {
        return this == GameOption.CONTINUE;
    }
}
