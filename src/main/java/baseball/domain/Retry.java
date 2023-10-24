package baseball.domain;

import java.util.stream.Stream;

public enum Retry {
    RETRY("1"), END("2"), DEFAULT("0");

    private static final String RETRY_FORMAT_EXCEPTION_MESSAGE = "[ERROR] 1 또는 2로 입력해야합니다.";
    private final String retrySymbol;

    Retry(String retrySymbol) {
        this.retrySymbol = retrySymbol;
    }

    public static Retry from(String rawRetry) {
        return Stream.of(values())
            .filter(retry -> retry.retrySymbol.equals(rawRetry))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException(RETRY_FORMAT_EXCEPTION_MESSAGE));
    }
}
