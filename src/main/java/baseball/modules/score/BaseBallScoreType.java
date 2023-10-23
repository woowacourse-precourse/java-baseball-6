package baseball.modules.score;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum BaseBallScoreType implements ScoreType{
    BALL("볼"),
    STRIKE("스트라이크")
    ;

    private final String scoreValue;

    BaseBallScoreType(final String scoreValue) {
        this.scoreValue = scoreValue;
    }

    public static Map<BaseBallScoreType, Integer> getInitScore() {
        return Stream.of(values())
                .collect(Collectors.toMap(
                        Function.identity(),
                        score -> 0,
                        (existing, replacement) -> existing,
                        LinkedHashMap::new));
    }

    public String getScoreValue() {
        return scoreValue;
    }
}
