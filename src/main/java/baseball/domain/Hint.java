package baseball.domain;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public enum Hint {
    STRIKE("스트라이크"),
    BALL("볼"),
    NOTHING("낫싱"),
    ;

    private final String inKorean;


    Hint(String inKorean) {
        this.inKorean = inKorean;
    }

    public String getInKorean() {
        return inKorean;
    }

}