package baseball.domain;

import static baseball.utils.ErrorMessages.NOT_MATCH_BASEBALL_RESULT;

import java.util.Arrays;
import java.util.function.Function;

public enum Result {
    BALL_STRIKE("{0}볼 {1}스트라이크", Judgment::isBallAndStrike),
    BALL("{0}볼", Judgment::isBall),
    ALL_STRIKE("{1}스트라이크", Judgment::isAllStrike),
    STRIKE("{1}스트라이크", Judgment::isStrike),
    NOTHING("낫싱", Judgment::isNothing),
    ;

    private final String messageFormat;
    private final Function<Judgment, Boolean> matcher;

    private Result(String messageFormat, Function<Judgment, Boolean> matcher) {
        this.messageFormat = messageFormat;
        this.matcher = matcher;
    }

    public static Result of(Judgment judgment) {
        return Arrays.stream(values())
                .filter(value -> value.matcher.apply(judgment))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(NOT_MATCH_BASEBALL_RESULT));
    }

    public String getMessageFormat() {
        return messageFormat;
    }
}
