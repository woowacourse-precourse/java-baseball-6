package baseball.view.constant;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum ResultType {

    NOTHING((strike, ball) -> strike == 0 && ball == 0, (strike, ball) -> "낫싱"),
    ONLY_BALL((strike, ball) -> strike == 0 && ball != 0, (strike, ball) -> ball + "볼"),
    ONLY_STRIKE((strike, ball) -> strike != 0 && ball == 0, (strike, ball) -> strike + "스트라이크"),
    STRIKE_AND_BALL((strike, ball) -> strike != 0 && ball != 0, (strike, ball) -> ball + "볼 " + strike + "스트라이크");

    private final BiFunction<Integer, Integer, Boolean> biFunction;
    private final BiFunction<Integer, Integer, String> messageFunction;

    // private constructor
    ResultType(BiFunction<Integer, Integer, Boolean> biFunction, BiFunction<Integer, Integer, String> messageFunction) {
        this.biFunction = biFunction;
        this.messageFunction = messageFunction;
    }

    // utility
    public static String getResultMessage(int strike, int ball) {
        return Arrays.stream(values())
                .filter(type -> type.biFunction.apply(strike, ball))
                .map(type -> type.messageFunction.apply(strike, ball))
                .findFirst()
                .orElseThrow();
    }
}
