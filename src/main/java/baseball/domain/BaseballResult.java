package baseball.domain;

import baseball.utils.ErrorMessages;
import java.util.Arrays;
import java.util.function.BiPredicate;

public enum BaseballResult {
    BALL_STRIKE("{0}볼 {1}스트라이크", (ball, strike) -> ball > 0 && strike > 0),
    BALL("{0}볼", (ball, strike) -> ball > 0 && strike == 0),
    ALL_STRIKE("{1}스트라이크", (ball, strike) -> ball == 0 && strike == 3),
    STRIKE("{1}스트라이크", (ball, strike) -> ball == 0 && strike > 0),
    NOTHING("낫싱", (ball, strike) -> ball == 0 && strike == 0),
    ;

    private final String messageFormat;
    private final BiPredicate<Integer, Integer> matcher;

    private BaseballResult(String messageFormat, BiPredicate<Integer, Integer> matcher) {
        this.messageFormat = messageFormat;
        this.matcher = matcher;
    }

    public static BaseballResult of(Baseball baseball) {
        int ball = baseball.getBall();
        int strike = baseball.getStrike();

        return Arrays.stream(BaseballResult.values())
                .filter(value -> value.matcher.test(ball, strike))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessages.NOT_MATCH_BASEBALL_RESULT));
    }

    public String getMessageFormat() {
        return messageFormat;
    }
}
