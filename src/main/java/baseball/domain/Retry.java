package baseball.domain;

import static baseball.domain.ErrorMessage.RETRY_IS_NOT_MATCHED;

import java.util.function.Predicate;
import java.util.stream.Stream;

public enum Retry {
    RETRY("1"), QUIT("2"), DEFAULT("0");

    private final String retrySymbol;

    Retry(String retrySymbol) {
        this.retrySymbol = retrySymbol;
    }

    private static Predicate<Retry> matchesRetrySymbol(String rawRetry) {
        return retry -> retry.retrySymbol.equals(rawRetry);
    }

    public static Retry from(String rawRetry) {
        return Stream.of(values())
            .filter(matchesRetrySymbol(rawRetry))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException(RETRY_IS_NOT_MATCHED));
    }

    public boolean isQuit() {
        return this == QUIT;
    }
}
