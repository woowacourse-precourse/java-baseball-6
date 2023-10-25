package baseball;

import java.util.Arrays;
import java.util.function.Function;

public enum BaseballResult {
    BALL_STRIKE("{0}볼 {1}스트라이크", Baseball::isBallAndStrike),
    BALL("{0}볼", Baseball::isBall),
    ALL_STRIKE("{1}스트라이크", Baseball::isAllStrike),
    STRIKE("{1}스트라이크", Baseball::isStrike),
    NOTHING("낫싱", Baseball::isNothing),
    ;

    private final String messageFormat;
    private final Function<Baseball, Boolean> matcher;

    private BaseballResult(String messageFormat, Function<Baseball, Boolean> matcher) {
        this.messageFormat = messageFormat;
        this.matcher = matcher;
    }

    public static BaseballResult of(Baseball baseball) {
        return Arrays.stream(BaseballResult.values())
                .filter(value -> value.matcher.apply(baseball))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessages.NOT_MATCH_BASEBALL_RESULT));
    }

    public String getMessageFormat() {
        return messageFormat;
    }
}
