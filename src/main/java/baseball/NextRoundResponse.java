package baseball;

import java.util.Arrays;

public enum NextRoundResponse {
    YES(1, true),
    NO(2, false);

    private final int responseNumber;
    private final boolean responseStatus;

    NextRoundResponse(int responseNumber, boolean responseStatus) {
        this.responseNumber = responseNumber;
        this.responseStatus = responseStatus;
    }

    public static NextRoundResponse getByResponseNumber(int responseNumber) {
        return Arrays.stream(NextRoundResponse.values()).filter(r -> r.responseNumber == responseNumber).findFirst()
                .orElseThrow(() -> new IllegalArgumentException(GameMessage.WRONG_INPUT.getMessage()));
    }

    public int getResponseNumber() {
        return responseNumber;
    }

    public boolean getResponseStatus() {
        return responseStatus;
    }
}
