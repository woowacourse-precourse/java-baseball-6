package baseball.domain;

import java.util.Arrays;

public enum ResponseStatus {
    RESTART("1"),
    END("2");

    private final String response;

    ResponseStatus(String response) {
        this.response = response;
    }

    public static ResponseStatus from(String response) {
        return Arrays.stream(ResponseStatus.values())
                .filter(s -> s.hasResponse(response))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("1 또는 2 로만 입력해주세요."));
    }

    private boolean hasResponse(String response) {
        return this.response.equals(response);
    }
}
